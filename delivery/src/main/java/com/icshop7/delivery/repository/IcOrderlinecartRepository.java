package com.icshop7.delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.icshop7.delivery.entity.Icorderlinecart;

public interface IcOrderlinecartRepository extends JpaRepository<Icorderlinecart, Integer> {
	@Query("SELECT t from Icorderlinecart t WHERE t.orderno=:orderno")
	List<Icorderlinecart> findByOrderno(Integer orderno);
	
}
