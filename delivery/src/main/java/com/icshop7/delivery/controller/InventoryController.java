package com.icshop7.delivery.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.icshop7.delivery.entity.Inventory;
import com.icshop7.delivery.exception.ResourceNotFoundException;
import com.icshop7.delivery.repository.InventoryRepository;

@CrossOrigin
@RestController
public class InventoryController {
	Random random =new Random();

	@Autowired
	InventoryRepository inventoryRepository;
	

	@GetMapping("/getinventory")
	public List<Inventory> getAllInventory() {

		return inventoryRepository.findAll(); // select * from user;
	}
	
	@PostMapping("/addinventory")
	public Inventory creatinventory(@RequestBody Inventory inventory) {
		
		inventory.setCreationdateretailer(LocalDate.now());
		ZoneId zone1 = ZoneId.of("Asia/Calcutta");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now(zone1);
        System.out.println(dtf.format(localTime));    // 16:37:15

		inventory.setCreationtime(dtf.format(localTime));
		inventory.setOrdernumber(random.nextInt(10000));
		inventory.setDeliverystatus("No");
		return inventoryRepository.save(inventory);
	}
	
	
	@DeleteMapping("/deleteinventory/{id}")
	public String deleteUser(@PathVariable("id") int id) {

		inventoryRepository.deleteById(id);

		return "Is deleted";
	}
	
	// update employee rest api
	
		@PutMapping("/inventoryss/{id}")
		public ResponseEntity<Inventory> updateEmployee(@PathVariable int id, @RequestBody Inventory employeeDetails){
			Inventory employee = inventoryRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
			
//			employee.setFirstName(employeeDetails.getFirstName());
//			employee.setLastName(employeeDetails.getLastName());
//			employee.setEmailId(employeeDetails.getEmailId());
//			
			Inventory updatedEmployee = inventoryRepository.save(employee);
			return ResponseEntity.ok(updatedEmployee);
		}
	
	
		@PutMapping("/updateinventory/{id}")
		public ResponseEntity<Inventory> updateInventory(@PathVariable int id){
			Inventory inventory = inventoryRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Inventory not exist with id :" + id));
			
//			employee.setFirstName(employeeDetails.getFirstName());
//			employee.setLastName(employeeDetails.getLastName());
//			employee.setEmailId(employeeDetails.getEmailId());
			if((inventory.getDeliverystatus()).equals("No")) {
				System.out.println("Changed to Yes");
				inventory.setDeliverystatus("Yes");
			}else{
			inventory.setDeliverystatus("No");
			System.out.println("Changed to No");
			}
//			
			Inventory updatedEmployee = inventoryRepository.save(inventory);
			return ResponseEntity.ok(updatedEmployee);
		}
		

		@GetMapping("/getoneinventory/{shopname}")
		public List<Inventory> getOneInventory(@PathVariable String shopname) {
           System.out.println("trying to pull one data");
			return inventoryRepository.findOneInventry(shopname); // select * from user;
		}
		


}
