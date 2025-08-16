package com.icshop7.delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.icshop7.delivery.entity.IcfinalOrderDTO;
import com.icshop7.delivery.entity.Icfinalorder;

public interface IcFinalOrderRepository extends JpaRepository<Icfinalorder, Integer> {
	
	@Query("SELECT t from Icfinalorder t WHERE t.customername=:customername and t.customerpassword=:customerpassword")
	List<Icfinalorder> findByPassword(String customername ,String customerpassword);
	
	
//	@Query(value="SELECT finalorderid,orderdate,orderno,creationtime,customername, vendorid,orderstatus from icfinalorder ",nativeQuery = true)
//	List<Icfinalorder> findAlldata();
	//,t.orderdate,t.orderno,t.creationtime,t.customername,t.vendorid,t.orderstatus
	//icfinalorderdata
	
//	@Query(value="SELECT finalorderid,orderdate,orderno,creationtime,customername, vendorid,orderstatus from icfinalorder ",nativeQuery = true)
//	List<IcfinalOrderDTO> findAlldata();
	
	@Query(value="SELECT finalorderid,orderdate,orderno,creationtime,customername, vendorid,orderstatus from icfinalorder ",nativeQuery = true)
	List<icfinalorderdata> findAlldata();
	
	
	@Query(value="SELECT finalorderid,orderdate,orderno,creationtime,customername, vendorid,orderstatus from icfinalorder where vendorid=:vendorid",nativeQuery = true)
	List<icfinalorderdata> findByVendorID(String vendorid);
	
}



