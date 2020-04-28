package com.online.shop.onlineshop.model.user;

import com.online.shop.onlineshop.model.Product;
import com.online.shop.onlineshop.repository.OrderRepository;
import com.online.shop.onlineshop.repository.ProductRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter

public class Client implements User {

    @Autowired
    ProductRepository productRepository;
    OrderRepository orderRepository;

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

    public void placeOrder(LocalDate dueDate, String additionalInfo, ArrayList<Product> orderedProducts) {
        Order order = new Order(System.currentTimeMillis());
        order.setPlacedDate((LocalDate.now()));
        order.setDueDate(dueDate);
        order.setAdditionalInfo(additionalInfo);
        order.setProductList(orderedProducts);
        order.setClient(this);
        productRepository.retrieveFromRepo(orderedProducts);
        order.setStatus("CONFIRMED");
        orderRepository.addOneOrderToRepo(order.getOrderId(), order);
    }
}
