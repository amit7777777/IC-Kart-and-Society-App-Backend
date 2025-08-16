package com.icshop7.delivery.repository;

public interface icproductdata {

	
	//to Pick up Specific records of data
	
//		Integer getFinalorderid();
//	    String getOrderdate();
//	    Integer getOrderno();
//	    String getCreationtime();
//	    String getCustomername();
////	    String getVendorid();
//	    String getOrderstatus();
//	    
	    //int productid;
	    Integer getProductid();
		//Fields need to be created and sent
//		String productname;
		String getProductname();
//		int productprice;
		Integer getProductprice();
//		String vendorid;
		String getVendorid();
//		String vendorcode;
//		String getVendorcode(); //dont want to expose
		//Default from Shop Owners
//		int discount;
		Integer getDiscount();
//		String itemavailablestatus;  //itemavailablestatus
		String getItemavailablestatus();
//		String shoponoffstatus;
		String getShoponoffstatus();
		//From Image picke up
//		String filepath;
		String getFilepath();
//		String name;
		String getName();
//		String type;
		String getType();

	
}
