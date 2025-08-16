package com.icshop7.delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.icshop7.delivery.entity.Inventory;


public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
	
	@Query(value = "SELECT * from creations e where e.shopname =:shopname ", nativeQuery = true)
	List<Inventory>findOneInventry(@Param("shopname") String Shopname);
	

}
