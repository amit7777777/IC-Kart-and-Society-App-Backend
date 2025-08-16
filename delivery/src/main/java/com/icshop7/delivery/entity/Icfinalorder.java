package com.icshop7.delivery.entity;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Icfinalorder {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int finalorderid;
	int productquantity;
	LocalDate orderdate;
	int orderno;
	int total;
	String creationtime;
	
	String customername;
	String customerpassword;
	String contact;
	String address;
	String citycode;
	
	int productid;
	String productname;
	int productprice;
	String vendorid;
	String vendorcode;
	int discount;
	String filepath;
	
	String orderstatus;
	

}
