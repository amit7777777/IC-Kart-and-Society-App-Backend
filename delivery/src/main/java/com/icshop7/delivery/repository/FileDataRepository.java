package com.icshop7.delivery.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.icshop7.delivery.entity.FileData;

public interface FileDataRepository extends JpaRepository<FileData,Long> {
    Optional<FileData> findByName(String fileName);


	@Query(value="SELECT * from file_data where societycode=:sc",nativeQuery = true)
	ArrayList<FileData> findAllSocietyCode(String sc);
	
	//New Query for date anges to be Added here
	
//	@Query(value = "SELECT * FROM file_data WHERE DATE_FORMAT(creationdate, '%d %m %Y') BETWEEN STR_TO_DATE(:startDate, '%d %m %Y') AND STR_TO_DATE(:endDate, '%d %m %Y')", nativeQuery = true)
//	ArrayList<FileData> findByDateRange(@Param("startDate") String startDate, @Param("endDate") String endDate);

	@Query(value="SELECT * FROM file_data WHERE creationdate >= :startDate AND creationdate <= :endDate",nativeQuery = true)
	ArrayList<FileData> findByDateRange( String startDate, String endDate);
	
	//SELECT * FROM `file_data` WHERE creationdate<='2013-01-03' and creationdate>='2025-01-09';
	
	@Query(value="SELECT * FROM file_data WHERE creationdate >= :startDate AND creationdate <= :endDate and societycode=:sc",nativeQuery = true)
	ArrayList<FileData> findByDateRangeSociety( String startDate, String endDate,String sc);
}
