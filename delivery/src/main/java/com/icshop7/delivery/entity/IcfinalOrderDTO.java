package com.icshop7.delivery.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IcfinalOrderDTO {
	
	
	int finalorderid;
//	int productquantity;
	LocalDate orderdate;
	int orderno;
//	int total;
	String creationtime;
	
	String customername;
//	String customerpassword;
//	String contact;
//	String address;
//	String citycode;
	
//	int productid;
//	String productname;
//	int productprice;
	String vendorid;
//	String vendorcode;
//	int discount;
//	String filepath;
	
	String orderstatus;
	

}
