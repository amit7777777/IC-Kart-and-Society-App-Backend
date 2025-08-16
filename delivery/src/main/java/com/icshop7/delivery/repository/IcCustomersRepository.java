package com.icshop7.delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.icshop7.delivery.entity.Iccustomers;

public interface IcCustomersRepository extends JpaRepository<Iccustomers, Integer> {
		@Query("SELECT t from Iccustomers t WHERE t.username=:username AND t.password=:password")
	List<Iccustomers> findByUsernamPassword(String username, String password);

}

