package com.icshop7.delivery.services;

import java.io.File;
//import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.icshop7.delivery.entity.Icproducts;
import com.icshop7.delivery.repository.IcProductsRepository;

@Service /// Service Annotation takes very important rode as component /service
public class IcCartAllServices {

	@Autowired
	private IcProductsRepository icproductRepository;

	// private final String FOLDER_PATH="C://Users/Amit/Desktop/imgeupload/";
	// C:\Users\Amit\Desktop\imgeupload

	// String FOLDER_PATH = System.getProperty("user.dir") + File.separator ;
	String FOLDER_PATH = "/home/ctdlifec/tomcat/webapps/icshop7.com/ROOT/imageUpload/";
//    
//    String homePath = System.getProperty("user.home");
//    String fileName = "test" + System.currentTimeMillis();
//    String filePath = homePath + File.separator + fileName;
//    System.out.println("filePath = " + filePath);

	// By Amit
	@Transactional
	public String uploadImageToFileSystem(MultipartFile file) throws IOException {
		String filePath = FOLDER_PATH + file.getOriginalFilename();
		System.out.println("Amit" + filePath);
		Icproducts fileData = icproductRepository.save(Icproducts.builder().name(file.getOriginalFilename())
				.type(file.getContentType()).filepath(filePath).build());

		file.transferTo(new File(filePath));

		if (fileData != null) {
			return "file uploaded successfully : " + filePath;
		}
		return null;
	}

	public byte[] downloadImageFromFileSystem(Integer id) throws IOException {
		Optional<Icproducts> fileData = icproductRepository.findById(id);// .findByName(fileName);
		String filePath = fileData.get().getFilepath();
		byte[] images = Files.readAllBytes(new File(filePath).toPath());
		return images;
	}
	
	@Transactional
	public String uploadImageToFileSystem(MultipartFile file, String productname, String productprice, String vendorid,
			String vendorcode) throws IllegalStateException, IOException {

		String filePath = FOLDER_PATH + file.getOriginalFilename();
		System.out.println("Amit" + filePath);
		Icproducts fileData = icproductRepository.save(
				Icproducts.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.filepath(filePath)
				.productname(productname)
				.productprice(Integer.parseInt(productprice))
				.vendorcode(vendorcode)
				.vendorid(vendorid)
				.discount(0)
				.itemavailablestatus("Yes")
				.shoponoffstatus("On")
				.build());

		file.transferTo(new File(filePath));

		if (fileData != null) {
			return "file uploaded successfully : " + filePath;
		}
		return null;
	}

}
