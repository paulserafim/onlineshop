package com.online.shop.onlineshop.model.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Client implements User {
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String county;
    private String country;
    private String street;
    private String houseNumber;
    private String encryptedPass;
    private String id;
    private double age;
    private String phoneNumber;
}
