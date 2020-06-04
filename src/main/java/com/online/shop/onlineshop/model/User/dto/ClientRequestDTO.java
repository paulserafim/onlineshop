package com.online.shop.onlineshop.model.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientRequestDTO {
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

    public ClientRequestDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
