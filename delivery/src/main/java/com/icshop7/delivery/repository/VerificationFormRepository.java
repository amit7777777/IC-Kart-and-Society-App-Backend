package com.icshop7.delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.icshop7.delivery.entity.Inventory;
import com.icshop7.delivery.entity.VerificationForm;

public interface VerificationFormRepository extends JpaRepository<VerificationForm, Long>{


	@Query(value = "SELECT * from verification_form e where e.societycode =:societycode ", nativeQuery = true)
	List<VerificationForm>findAllBySocietyCode(@Param("societycode") String societycode);
	
}
