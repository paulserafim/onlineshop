package com.online.shop.onlineshop.model.user.dto;

import com.online.shop.onlineshop.model.user.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Access;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String county;
    private String country;
    private String street;
    private String houseNumber;
    private Long id;
    private double age;
    private String phoneNumber;

    public ClientResponseDTO(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
