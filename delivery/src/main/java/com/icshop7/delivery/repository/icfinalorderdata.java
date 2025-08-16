package com.icshop7.delivery.repository;

public interface icfinalorderdata {
	
	
	//to Pick up Specific records of data
	
	

	Integer getFinalorderid();
    String getOrderdate();
    Integer getOrderno();
    String getCreationtime();
    String getCustomername();
    String getVendorid();
    String getOrderstatus();

}
