package com.icshop7.delivery.entity;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VerificationForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
   // private String phonenumber;
    private String age;
    private String contact;
    private String parking4;
    private String parking2;
    private String ownercontact;
    private String ownername;
    private String wingno;
    private String flatno;

    
    
    
    
    private String societycode;
    public LocalDate creationdate;
    private String duration;
    public String rentdate;
    
    
    
   // private String address;
    private String pancardpath;
    private String aadhaarcardpath;
    

    // Getters and setters
}