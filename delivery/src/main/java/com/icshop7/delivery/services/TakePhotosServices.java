package com.icshop7.delivery.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.icshop7.delivery.entity.FileData;
import com.icshop7.delivery.entity.TakePhotos;
import com.icshop7.delivery.repository.FileDataRepository;
import com.icshop7.delivery.repository.TakePhotosRepository;



@Service
public class TakePhotosServices {

	@Autowired
	private FileDataRepository fileDataRepository;

	@Autowired
	private TakePhotosRepository takephotosrepository;

	// private final String
	// FOLDER_PATH="\\home\\ctdlifec\\tomcat\\webapps\\imageUpload\\";
	// "C://Users/Amit/Desktop/imgeupload/";
	// C:\Users\Amit\Desktop\imgeupload
	// /tomcat/webapps/icshop7.com/ROOT/imageUpload
	// "/home/ctdlifec/tomcat/webapps/icshop7.com/ROOT/imageUpload/";
	String FOLDER_PATH = "/home/ctdlifec/tomcat/webapps/icshop7.com/ROOT/imageUpload2/";

// String FOLDER_PATH = System.getProperty("user.dir");

	// By Amit
	@Transactional
	public String uploadImageToFileSystem(MultipartFile file) throws IOException {
		String filePath = FOLDER_PATH + file.getOriginalFilename();
		System.out.println(filePath);
		FileData fileData = fileDataRepository
				.save(FileData.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.filePath(filePath)
				.build());

		file.transferTo(new File(filePath));

		if (fileData != null) {
			return "file uploaded successfully : " + filePath;
		}
		return null;
	}
	
	//New method for Adding cost data
	@Transactional
	public String uploadImageToFileSystem(MultipartFile file,String one) throws IOException {
		String filePath = FOLDER_PATH + file.getOriginalFilename();
		System.out.println(filePath);
		////////20 feb 2024 to add date to our Entity////
//		file.setOrderdate(LocalDate.now());
//		ZoneId zone1 = ZoneId.of("Asia/Calcutta");
//
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
//		LocalTime localTime = LocalTime.now(zone1);
//		System.out.println(dtf.format(localTime)); // 16:37:15
//
//		Icfinalorder.setCreationtime(dtf.format(localTime));
		/////////////////20 feb 2024 to add date to our Entity/////////
		
		
		FileData fileData = fileDataRepository
				.save(FileData.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.filePath(filePath)
				.cost(one)	
				.build());

		file.transferTo(new File(filePath));

		if (fileData != null) {
			return "file uploaded successfully : " + filePath;
		}
		return null;
	}

	public byte[] downloadImageFromFileSystem(Long id) throws IOException {
		Optional<FileData> fileData = fileDataRepository.findById(id);// .findByName(fileName);
		String filePath = fileData.get().getFilePath();
		byte[] images = Files.readAllBytes(new File(filePath).toPath());
		return images;
	}

	///////////////////// new service for take Photos/////////////

	public byte[] downloadImageFromFileSystem(Integer id) throws IOException {
		Optional<TakePhotos> fileData = takephotosrepository.findById(id);// .findByName(fileName);
		String filePath = fileData.get().getFilePath();
		byte[] images = Files.readAllBytes(new File(filePath).toPath());
		return images;
	}
	@Transactional
	public String uploadImageToFileSystem(MultipartFile file, String cost, String societycode, String descreption)
			throws IllegalStateException, IOException {

		String filePath = FOLDER_PATH + file.getOriginalFilename();
		String filePath2 = FOLDER_PATH + file.getOriginalFilename();
		System.out.println(filePath2);
		//Logic for creation date need to be added
		//Icfinalorder.setOrderdate(LocalDate.now());
		ZoneId zone1 = ZoneId.of("Asia/Calcutta");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime localTime = LocalTime.now(zone1);
		System.out.println(dtf.format(localTime)); // 16:37:15

		//Icfinalorder.setCreationtime(dtf.format(localTime));
		///////////////////////////////////////////////////
		
		
		
		TakePhotos fileData = takephotosrepository
				.save(TakePhotos.builder()
						.name(file.getOriginalFilename())
						.type(file.getContentType())
						.filePath(filePath2)
						.cost(cost)
						.societycode(societycode)
						.descreption(descreption)
						.creationtime(dtf.format(localTime))
						.creationdate(LocalDate.now())
						.build());

		file.transferTo(new File(filePath));

		if (fileData != null) {
			return "file uploaded successfully : " + filePath;
		}
		return null;

		///////////////////// might need to be deleted/////
//	System.out.println("Amit"+ filePath);
//	         fileData=takephotosrepository.save(TakePhotos.builder()
//	                .name(file.getOriginalFilename())
//	                .type(file.getContentType())
//	                .filePath(filePath)
//	                .cost(cost)
//	                .societycode(societycode)
//	                .descreption(descreption).build());
//
//	        file.transferTo(new File(filePath));
//
//	        if (fileData != null) {
//	            return "file uploaded successfully : " + filePath;
//	        }
//	        return null;
		//////////////////////////////////////////////////////////////
	}

}
