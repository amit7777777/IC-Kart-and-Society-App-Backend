package com.icshop7.delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.icshop7.delivery.entity.Icproducts;

public interface IcProductsRepository extends JpaRepository<Icproducts, Integer> {
	
	@Query("SELECT t from Icproducts t WHERE t.vendorid=:vendorid")
	List<Icproducts> findByVendorId(String vendorid);
	
	@Query(value="SELECT productid,productname,productprice,vendorid,discount,itemavailablestatus,shoponoffstatus,filepath,name,type from icproducts where vendorid=:vendorid",nativeQuery = true)
	List<icproductdata> findAllHideVendorCode(String vendorid);//find All with vendorID
	
	@Query(value="SELECT productid,productname,productprice,vendorid,discount,itemavailablestatus,shoponoffstatus,filepath,name,type from icproducts ",nativeQuery = true)
	List<icproductdata> findAllHideVendorCode2(); //find All without vendotID
	

}
