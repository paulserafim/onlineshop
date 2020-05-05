package com.online.shop.onlineshop.model.user.dto;

import com.online.shop.onlineshop.model.user.Client;
import com.online.shop.onlineshop.model.user.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {

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
    private String role;

}
