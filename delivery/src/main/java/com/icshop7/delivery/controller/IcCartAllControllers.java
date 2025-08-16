package com.icshop7.delivery.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.icshop7.delivery.entity.Iccustomers;
import com.icshop7.delivery.entity.Icfinalorder;
import com.icshop7.delivery.entity.Icorderlinecart;
import com.icshop7.delivery.entity.Icproducts;
import com.icshop7.delivery.exception.ResourceNotFoundException;
import com.icshop7.delivery.repository.IcCustomersRepository;
import com.icshop7.delivery.repository.IcFinalOrderRepository;
import com.icshop7.delivery.repository.IcOrderlinecartRepository;
import com.icshop7.delivery.repository.IcProductsRepository;
import com.icshop7.delivery.repository.icfinalorderdata;
import com.icshop7.delivery.repository.icproductdata;
import com.icshop7.delivery.services.IcCartAllServices;

//@CrossOrigin("*")  this added or managed  in web.xml file for cors related things ....

//@CrossOrigin(origins = "https://localhost:4200")
@RestController
@RequestMapping("/image")
public class IcCartAllControllers {

	@Autowired
	IcCustomersRepository Iccustomersrepository;

	@GetMapping("/iccustomer")
	public List<Iccustomers> getAllIccustomer() {

		return Iccustomersrepository.findAll(); // select * from user;
	}

	// create POST
	// create employee rest api66666
	@PostMapping("/iccustomer")
	public Iccustomers createIccustomer(@RequestBody Iccustomers iccustomer) {
		return Iccustomersrepository.save(iccustomer);
	}

	@DeleteMapping("/iccustomer/{id}")
	public String deleteIccustomer(@PathVariable("id") int id) {

		Iccustomersrepository.deleteById(id);

		return "Is deleted";
	}

	@GetMapping("/iccustomervalid/{username}/{password}")
	public List<Iccustomers> getAllvalidIccustomer(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		System.out.println("amit " + username);
		return Iccustomersrepository.findByUsernamPassword(username, password); // select * from user;
	}

	////////////////////// Images andProducts to be taken care
	////////////////////// /////////////////////////

	@Autowired
	private IcCartAllServices iccartallservice;

	@Autowired
	private IcProductsRepository icProductrepository;

	// Amit Tring to pull All images
	@GetMapping("/icall")
	public Optional<List<Icproducts>> downloadImage2() {
		return Optional.ofNullable(icProductrepository.findAll());

	}

	@GetMapping("/icall/{vendorid}")
	public Optional<List<Icproducts>> downloadImage3(@PathVariable("vendorid") String vendorid) {
		return Optional.ofNullable(icProductrepository.findByVendorId(vendorid));

	}
	
	//added by Amit for hide vendor details 
	@GetMapping("/icallhidevendor/{vendorid}")
	public Optional<List<icproductdata>> downloadImage4(@PathVariable("vendorid") String vendorid) {
		return Optional.ofNullable(icProductrepository.findAllHideVendorCode(vendorid));

	}
	
	//added by Amit for hide vendor details 
		@GetMapping("/icallhidevendor")
		public Optional<List<icproductdata>> downloadImage5() {
			return Optional.ofNullable(icProductrepository.findAllHideVendorCode2());

		}
	
	
	

	@PostMapping("/icfileSystem/{productname}/{productprice}/{vendorid}/{vendorcode}")
	public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image") MultipartFile file,
			@PathVariable("productname") String productname, @PathVariable("productprice") String productprice,
			@PathVariable("vendorid") String vendorid, @PathVariable("vendorcode") String vendorcode)
			throws IOException {
		System.out.println(file.getName());
		System.out.println(file.toString());
		System.out.println("Amit" + productname);
		System.out.println("Amit" + productprice);
		String uploadImage = iccartallservice.uploadImageToFileSystem(file, productname, productprice, vendorid,
				vendorcode);
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}

	// @GetMapping("/fileSystem/{fileName}/{id}")
	@GetMapping("/icfileSystem/{id}")

	public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable Integer id) throws IOException {
		byte[] imageData = iccartallservice.downloadImageFromFileSystem(id);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);

	}
	


	// Product related Put or Update Operations /////////////////

	@PutMapping("/icproductupdate/{id}")
	public ResponseEntity<Icproducts> updateProduct(@PathVariable int id) {
		Icproducts inventory = icProductrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Inventory not exist with id :" + id));

		if (inventory.getItemavailablestatus().equals("No")) {
			System.out.println("Changed to Yes");
			inventory.setItemavailablestatus("Yes");
		} else {
			inventory.setItemavailablestatus("No");
			System.out.println("Changed to No");
		}
//			
		Icproducts updatedEmployee = icProductrepository.save(inventory);
		return ResponseEntity.ok(updatedEmployee);
	}

	// Product Price to be Updated
	// icpriceproductupdate

	@PutMapping("/icpriceproductupdate/{id}/{price}")
	public ResponseEntity<Icproducts> updatePriceProduct(@PathVariable int id, @PathVariable int price) {
		Icproducts inventory = icProductrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Inventory not exist with id :" + id));

		inventory.setProductprice(price);

		Icproducts updatedEmployee = icProductrepository.save(inventory);
		return ResponseEntity.ok(updatedEmployee);
	}

	// Delete any Product from Product Catologues
	@DeleteMapping("/icproduct/{id}")
	public String deleteIproduct(@PathVariable("id") int id) {

		icProductrepository.deleteById(id);

		return "Is deleted";
	}

	///////////////////////////////// lineOrderProductcart///////////////////////

	@Autowired
	IcOrderlinecartRepository icorderlinecartrepository;

	@PostMapping("/iclineordercart/{username}/{password}/{orderno}/{address}")
	public Icorderlinecart createIclineOrderCart(@RequestBody Icorderlinecart icorderlinecart,
			@PathVariable("username") String username, @PathVariable("password") String password,
			@PathVariable("orderno") Integer orderno, @PathVariable("address") String address) {
		icorderlinecart.setOrderdate(LocalDate.now());
		ZoneId zone1 = ZoneId.of("Asia/Calcutta");
		icorderlinecart.setProductquantity(1);
		icorderlinecart.setCustomername(username);
		icorderlinecart.setCustomerpassword(password);
		icorderlinecart.setOrderno(orderno);
		icorderlinecart.setAddress(address);

		return icorderlinecartrepository.save(icorderlinecart);
	}

	@GetMapping("/iclineordercart/{orderno}")
	public Optional<List<Icorderlinecart>> getIclineOrderCart(@PathVariable("orderno") Integer orderno) {
		return Optional.ofNullable(icorderlinecartrepository.findByOrderno(orderno));

	}

	@DeleteMapping("/iclineordercart/{orderid}")
	public String deleteIclineOrderCart(@PathVariable("orderid") Integer orderid) {
		icorderlinecartrepository.deleteById(orderid);
		return "Record deleted Successfully";

	}

	///////////////////////// Final Order////////////////////////////

	@Autowired
	IcFinalOrderRepository icfinalorderrepository;

	@PostMapping("/icfinalordercart/{username}/{password}/{orderno}/{vedorid}/{address}")
	public Icfinalorder createIcfinalOrderCart(@RequestBody Icfinalorder Icfinalorder,
			@PathVariable("username") String username, @PathVariable("password") String password,
			@PathVariable("orderno") Integer orderno, @PathVariable("vedorid") String vedorid,
			@PathVariable("address") String address) {
		// Icfinalorder icfinaloder2 = new Icfinalorder();
		Icfinalorder.setOrderdate(LocalDate.now());
		ZoneId zone1 = ZoneId.of("Asia/Calcutta");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime localTime = LocalTime.now(zone1);
		System.out.println(dtf.format(localTime)); // 16:37:15

		Icfinalorder.setCreationtime(dtf.format(localTime));

		Icfinalorder.setProductquantity(1);
		Icfinalorder.setCustomername(username);
		Icfinalorder.setCustomerpassword(password);
		Icfinalorder.setOrderno(orderno);
		Icfinalorder.setVendorid(vedorid);
		Icfinalorder.setOrderstatus("No");
		Icfinalorder.setAddress(address);

		return icfinalorderrepository.save(Icfinalorder);
	}

//		@GetMapping("/icfinalordercart")
//		public Optional<List<Icfinalorder>> getIcfinalOrderCart(){
//				return Optional.ofNullable(icfinalorderrepository.findAll());
//
//			}

	@GetMapping("/icfinalorderpassword/{username}/{password}")
	public Optional<List<Icfinalorder>> getIcfinalOrderCartPassword(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		return Optional.ofNullable(icfinalorderrepository.findByPassword(username, password));

	}

	
	@RequestMapping(value = "/icfinalordercartupdate/{id}", 
			  produces = "application/json", 
			  method=RequestMethod.PUT)
	//@PutMapping("/icfinalordercartupdate/{id}")
	public ResponseEntity<Icfinalorder> updateInventory(@PathVariable int id) {
		Icfinalorder inventory = icfinalorderrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Inventory not exist with id :" + id));

		if ((inventory.getOrderstatus()).equals("No")) {
			System.out.println("Changed to Yes");
			inventory.setOrderstatus("Yes");
		} else {
			inventory.setOrderstatus("No");
			System.out.println("Changed to No");
		}
//			
		Icfinalorder updatedEmployee = icfinalorderrepository.save(inventory);
		return ResponseEntity.ok(updatedEmployee);
	}

	@GetMapping("/icfinalordercart")
	public Optional<List<icfinalorderdata>> getIcfinalOrderCart2() {
		return Optional.ofNullable(icfinalorderrepository.findAlldata());

	}

	@GetMapping("/icfinalordercartvendorid/{vendorid}")
	public Optional<List<icfinalorderdata>> getIcfinalOrderCart3(@PathVariable("vendorid") String vendorid) {
		return Optional.ofNullable(icfinalorderrepository.findByVendorID(vendorid));

	}

}
