package com.icshop7.delivery.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "creations")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	String shopid;
	String shopname;
	LocalDate creationdateretailer;
	String creationtime;
	String supplytimedelivered;
	long ordernumber;
	String deliverystatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public LocalDate getCreationdateretailer() {
		return creationdateretailer;
	}
	public void setCreationdateretailer(LocalDate creationdateretailer) {
		this.creationdateretailer = creationdateretailer;
	}
	public String getCreationtime() {
		return creationtime;
	}
	public void setCreationtime(String creationtime) {
		this.creationtime = creationtime;
	}
	public String getSupplytimedelivered() {
		return supplytimedelivered;
	}
	public void setSupplytimedelivered(String supplytimedelivered) {
		this.supplytimedelivered = supplytimedelivered;
	}
	public long getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(long ordernumber) {
		this.ordernumber = ordernumber;
	}
	public String getDeliverystatus() {
		return deliverystatus;
	}
	public void setDeliverystatus(String deliverystatus) {
		this.deliverystatus = deliverystatus;
	}
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inventory(int id, String shopid, String shopname, LocalDate creationdateretailer, String creationtime,
			String supplytimedelivered, long ordernumber, String deliverystatus) {
		super();
		this.id = id;
		this.shopid = shopid;
		this.shopname = shopname;
		this.creationdateretailer = creationdateretailer;
		this.creationtime = creationtime;
		this.supplytimedelivered = supplytimedelivered;
		this.ordernumber = ordernumber;
		this.deliverystatus = deliverystatus;
	}
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", shopid=" + shopid + ", shopname=" + shopname + ", creationdateretailer="
				+ creationdateretailer + ", creationtime=" + creationtime + ", supplytimedelivered="
				+ supplytimedelivered + ", ordernumber=" + ordernumber + ", deliverystatus=" + deliverystatus + "]";
	}

	
	
}
