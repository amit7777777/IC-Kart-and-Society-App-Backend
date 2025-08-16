package com.icshop7.delivery.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.icshop7.delivery.entity.FileData;
import com.icshop7.delivery.repository.FileDataRepository;
import com.icshop7.delivery.services.StorageService;
import com.icshop7.delivery.services.TakePhotosServices;

@CrossOrigin
@RestController
@RequestMapping("/image")
public class ImageFileController {

	@Autowired
	private StorageService service;

	@Autowired
	private FileDataRepository filedatarepository;

	@Autowired
	private TakePhotosServices takephotosservices;

	// Amit Tring to pull All images
	@GetMapping("/all")
	public Optional<List<FileData>> downloadImage2() {
		return Optional.ofNullable(filedatarepository.findAll());

	}

	// Amit Tring to pull All images based on society code
	@GetMapping("/allsocietycode/{societycode}")
	public ArrayList<FileData> downloadImage3(@PathVariable("societycode") String societycode) throws IOException {
		return filedatarepository.findAllSocietyCode(societycode);

	}

	// Amit Tring to pull All images based on startDate and EndDate
	@GetMapping("/allsocietycode/{societycode}/{startDate}/{endDate}")
	public ArrayList<FileData> downloadImage4(@PathVariable("societycode") String societycode,
			@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate)
			throws IOException {
		return filedatarepository.findByDateRangeSociety(startDate, endDate,societycode);

	}

	@PostMapping("/fileSystem")
	public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image") MultipartFile file) throws IOException {
		System.out.println(file.getName());
		System.out.println(file.toString());
		String uploadImage = service.uploadImageToFileSystem(file);
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}

	// @GetMapping("/fileSystem/{fileName}/{id}")
	@GetMapping("/fileSystem/{id}")

	public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable Long id) throws IOException {
		byte[] imageData = service.downloadImageFromFileSystem(id);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);

	}

	// Trying to add data to it in uploadImageToFileSystem
	@PostMapping("/fileSystem/{data}")
	public ResponseEntity<?> uploadImageToFIleSystemwithData(@RequestParam("image") MultipartFile file,
			@PathVariable("data") String data) throws IOException {
		System.out.println(file.getName());
		System.out.println(file.toString());
		System.out.println("Amit" + data);
		String uploadImage = service.uploadImageToFileSystem(file, data);
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}

	// Trying to add data to it in uploadImageToFileSystem
	@PostMapping("/fileSystem/{data}/{cost}/{desc}")
	public ResponseEntity<?> uploadImageToFIleSystemwithData(@RequestParam("image") MultipartFile file,
			@PathVariable("data") String data, @PathVariable("cost") String cost, @PathVariable("desc") String desc)
			throws IOException {
		System.out.println(file.getName());
		System.out.println(file.toString());
		System.out.println("Amit" + data);
		String uploadImage = service.uploadImageToFileSystem(file, data, cost, desc);
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}

	/////////////////// controller part for takephotos///////////////

//	@PostMapping("/fileSystem/{data}/{cost}/{desc}")
//	public ResponseEntity<?> uploadImageToFIleSystemwithDataCostDesc(@RequestParam("image") MultipartFile file,
//			@PathVariable("data") String data,@PathVariable("societycode") String societycode,@PathVariable("descreption") String descreption) throws IOException {
//		System.out.println(file.getName());
//		System.out.println(file.toString());
//		System.out.println("Amit" + data);
//		String uploadImage = takephotosservices.uploadImageToFileSystem(file,data,societycode,descreption);
//		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
//	}

}
