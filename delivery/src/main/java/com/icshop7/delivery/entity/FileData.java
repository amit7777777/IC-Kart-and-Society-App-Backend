package com.icshop7.delivery.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import javax.persistence.*;
@Entity
@Table(name = "FILE_DATA")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Id
    private String name;
    private String type;
    private String filePath;
    
    //3 more fields got Added to it for cost ,scociety code and descreption
    private String cost;
    private String societycode;
    private String descreption;
    
  //2 more fields added time and date by Amit 21/02/2024
  	public String creationtime;
  	public LocalDate creationdate;
}
