package com.icshop7.delivery.entity;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity


public class Icorderlinecart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int orderid;
	int productquantity;
	LocalDate orderdate;
	int orderno;
	
	String customername;
	String customerpassword;
	
	int productid;
	String productname;
	int productprice;
	String vendorid;
	String vendorcode; 
	String filepath;
	String address;
	
	
	
	

}
