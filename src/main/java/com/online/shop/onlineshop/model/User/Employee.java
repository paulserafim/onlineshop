package com.online.shop.onlineshop.model.user;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Employee implements User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String county;
    private String country;
    private String street;
    private String houseNumber;
    private String encryptedPass;
    private double age;
    private String phoneNumber;
    private String role;

    public Employee(String firstName, String lastName, String email, String city, String county, String country, String street, String houseNumber, String encryptedPass, double age, String phoneNumber, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.county = county;
        this.country = country;
        this.street = street;
        this.houseNumber = houseNumber;
        this.encryptedPass = encryptedPass;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }
}
