package com.icshop7.delivery.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
public class Icproducts {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int productid;
	//Fields need to be created and sent
	String productname;
	int productprice;
	String vendorid;
	String vendorcode;
	
	//Default from Shop Owners
	int discount;
	String itemavailablestatus;
	String shoponoffstatus;
	//From Image picke up
	String filepath;
	String name;
	String type;
	
	

}
