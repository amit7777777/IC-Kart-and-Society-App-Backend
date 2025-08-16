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
import com.icshop7.delivery.repository.FileDataRepository;

@Service
public class StorageService {

    

    @Autowired
    private FileDataRepository fileDataRepository;

  //  private final String FOLDER_PATH="\\home\\ctdlifec\\tomcat\\webapps\\imageUpload\\";  
    //        "C://Users/Amit/Desktop/imgeupload/";
              //C:\Users\Amit\Desktop\imgeupload
    //        /tomcat/webapps/icshop7.com/ROOT/imageUpload
   //  "/home/ctdlifec/tomcat/webapps/icshop7.com/ROOT/imageUpload/"; 
    String FOLDER_PATH="/home/ctdlifec/tomcat/webapps/icshop7.com/ROOT/imageUpload2/";
    
// String FOLDER_PATH = System.getProperty("user.dir");

    //By Amit
  



   
@Transactional
    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath=FOLDER_PATH+file.getOriginalFilename();
      System.out.println(filePath);
        FileData fileData=fileDataRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }
    
    //Trying to pass data cost to backend
@Transactional
    public String uploadImageToFileSystem(MultipartFile file,String one) throws IOException {
        String filePath=FOLDER_PATH+file.getOriginalFilename();
      System.out.println(filePath);
        FileData fileData=fileDataRepository.save(FileData.builder()
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
    
    
    //Trying to pass data cost to backend fo 3 data 
@Transactional
    public String uploadImageToFileSystem(MultipartFile file,String one,String two,String three) throws IOException {
        String filePath=FOLDER_PATH+file.getOriginalFilename();
      System.out.println(filePath);
      
             //Logic for creation date need to be added
    		//Icfinalorder.setOrderdate(LocalDate.now());
    		ZoneId zone1 = ZoneId.of("Asia/Calcutta");

    		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    		LocalTime localTime = LocalTime.now(zone1);
    		System.out.println(dtf.format(localTime)); // 16:37:15

    		//Icfinalorder.setCreationtime(dtf.format(localTime));
    		///////////////////////////////////////////////////
    		
      
      
        FileData fileData=fileDataRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath)
                .cost(one)
                .societycode(two)
                .descreption(three)
                .creationtime(dtf.format(localTime))
				.creationdate(LocalDate.now())
                .build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(Long id) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findById(id);//.findByName(fileName);
        String filePath=fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }



}
