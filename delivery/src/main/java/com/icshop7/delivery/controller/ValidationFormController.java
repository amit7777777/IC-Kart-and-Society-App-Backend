package com.icshop7.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.icshop7.delivery.entity.FileData;
import com.icshop7.delivery.entity.User;
import com.icshop7.delivery.entity.VerificationForm;
import com.icshop7.delivery.repository.VerificationFormRepository;

@RestController
//@RequestMapping("/image")
//@CrossOrigin
public class ValidationFormController {

 String FOLDER_PATH="/home/ctdlifec/tomcat/webapps/icshop7.com/ROOT/imageUpload2/";

	//String FOLDER_PATH = "E:\\Amit D Drive\\Gyan\\Software\\Capgemini\\tp\\";

	@Autowired
	VerificationFormRepository verificationFormRepository;

	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestParam("file") MultipartFile panCardFile,
			@RequestParam("file") MultipartFile aadharCardFile) {
		// Save the uploaded files to a specific location
		VerificationForm vf = new VerificationForm();
		String pancardpath = "FOLDER_PATH" + panCardFile.getOriginalFilename();
		String aadhaarcardpath = "FOLDER_PATH" + aadharCardFile.getOriginalFilename();
		vf.setPancardpath(pancardpath);
		vf.setAadhaarcardpath(aadhaarcardpath);
		// Logic to save user information and file paths to the database
		verificationFormRepository.save(vf);
		return ResponseEntity.ok("User added successfully");
	}

	@PostMapping("/upload/{name}/{age}")
	public String handleFileUpload(@RequestParam("file") MultipartFile[] files, @PathVariable("name") String name,
			@PathVariable("age") String age) {
		VerificationForm vf = new VerificationForm();
		vf.setName(name);
		vf.setAge(age);
		// Save the uploaded file to a specific location
		int counter = 0;
		for (MultipartFile file : files) {
			String fileName = file.getOriginalFilename();

			File destFile = new File(FOLDER_PATH + fileName);
			counter++;
			if (counter == 1) {
				vf.setPancardpath(FOLDER_PATH + fileName);
			}
			if (counter == 2) {
				vf.setAadhaarcardpath(FOLDER_PATH + fileName);
				
			}
			System.out.println(destFile);

			try {
				file.transferTo(destFile);

			} catch (IOException e) {
				e.printStackTrace();
				return "File upload failed";
			}
		}
		verificationFormRepository.save(vf);
		return "success";
	}

	@PostMapping("/upload")
    public ResponseEntity<String> uploadFiles(@RequestParam("name") String name,
                                               @RequestParam("age") String age,
                                               @RequestParam("contact") String contact,
                                               @RequestParam("parking4") String parking4,
                                               @RequestParam("parking2") String parking2,
                                               @RequestParam("ownercontact") String ownercontact,
                                               @RequestParam("ownername") String ownername,
                                               @RequestParam("wingno") String wingno,
                                               @RequestParam("flatno") String flatno,
                                               @RequestParam("societycode") String societycode,
                                               @RequestParam("duration") String duration,
                                               @RequestParam("rentdate") String rentdate,
                                               
                                               
                                               @RequestPart("file1") MultipartFile file1,
                                               @RequestPart("file2") MultipartFile file2) throws IllegalStateException, IOException {
        // Process the uploaded files and user data
        // You can save the files, validate the data, etc.
		VerificationForm vf = new VerificationForm();
		vf.setName(name);
		vf.setAge(age);
		vf.setParking4(parking4);
		vf.setParking2(parking2);
		vf.setContact(contact);
		vf.setOwnercontact(ownercontact);
		vf.setOwnername(ownername);
		vf.setWingno(wingno);
		vf.setFlatno(flatno);
		vf.setSocietycode(societycode);
		
		vf.setDuration(duration);//Added Later
		vf.setRentdate(rentdate); //Added Later work Later
		
		
		
		
		
		vf.setPancardpath(FOLDER_PATH + file1.getOriginalFilename());
		vf.setAadhaarcardpath(FOLDER_PATH + file2.getOriginalFilename());
		

        // For demonstration purposes, we'll just print the details
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("File 1 Name: " + file1.getOriginalFilename());
        System.out.println("File 2 Name: " + file2.getOriginalFilename());
        File destFile = new File(FOLDER_PATH + file1.getOriginalFilename());
        File destFile2 = new File(FOLDER_PATH + file2.getOriginalFilename());
        System.out.println(destFile.toString());
        file1.transferTo(destFile);
        file2.transferTo(destFile2);
        vf.setCreationdate(LocalDate.now());
        
        
        
        
        
        
    	verificationFormRepository.save(vf);
        return ResponseEntity.ok("Files uploaded successfully");
    }
	
	
	@GetMapping("/getresidents")
	public List<VerificationForm> getAllResidents() {

		return verificationFormRepository.findAll(); // select * from user;
	}
	
	@GetMapping("/getresidents/{societycode}")
	public List<VerificationForm> getAllResidentsBasedonCode(@PathVariable String societycode) {

		return verificationFormRepository.findAllBySocietyCode(societycode); // select * from user;
	}
	
	// @GetMapping("/fileSystem/{fileName}/{id}")
		@GetMapping("/getresidentimageaadhar/{id}")

		public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable Long id) throws IOException {
			
			Optional<VerificationForm> fileData = verificationFormRepository.findById(id);//.findByName(fileName);
	        String filePath=fileData.get().getAadhaarcardpath();
	        byte[] images = Files.readAllBytes(new File(filePath).toPath());
	        //return images;
			//byte[] imageData = service.downloadImageFromFileSystem(id);
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(images);

		}
		@GetMapping("/getresidentimagepan/{id}")

		public ResponseEntity<?> downloadImageFromFileSystemPan(@PathVariable Long id) throws IOException {
			
			Optional<VerificationForm> fileData = verificationFormRepository.findById(id);//.findByName(fileName);
	        String filePath=fileData.get().getPancardpath();
	        byte[] images = Files.readAllBytes(new File(filePath).toPath());
	        //return images;
			//byte[] imageData = service.downloadImageFromFileSystem(id);
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(images);

		}
	
//fast2sms -: 	WQUvuq56STNnoj3kHg84OIFPJsx9XAZmRdrC7GczbVa1efplyiBpEInf2oJ9YwkNTv8OaVUGlD0Ssm36
	
	
}
