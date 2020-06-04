package com.online.shop.onlineshop.model.user;

import com.online.shop.onlineshop.model.Basket;
import com.online.shop.onlineshop.model.ClientOrder;
import com.online.shop.onlineshop.model.Inventory;
import com.online.shop.onlineshop.model.Product;
import com.online.shop.onlineshop.service.ClientOrderService;
import com.online.shop.onlineshop.service.InventoryService;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Client implements User {


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

    @OneToMany (mappedBy = "client", cascade = CascadeType.ALL)
    private List<Basket> baskets;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<ClientOrder> clientOrderList;


    public Client (String firstName, String lastName, String email, String city, String county, String country, String street, String houseNumber, double age, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.county = county;
        this.country = country;
        this.street = street;
        this.houseNumber = houseNumber;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public Client(String firstName, String lastName, String email, String city, String county, String country, String street, String houseNumber, String encryptedPass, double age, String phoneNumber) {
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
    }


}
