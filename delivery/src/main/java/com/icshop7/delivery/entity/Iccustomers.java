package com.icshop7.delivery.entity;


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
public class Iccustomers {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	int customerid;
	String username;
	String contact;
	String address;
	String citycode;
	String password;

}
