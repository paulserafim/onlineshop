package com.online.shop.onlineshop.model.user;

import com.online.shop.onlineshop.model.Product;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Order {
    private long orderId;
    private List <Product> productList = new ArrayList<>();
    private Client client;
    private LocalDate placedDate;
    private LocalDate dueDate;
    private String status;
    private String additionalInfo;

    public Order(long orderId) {
        this.orderId = orderId;
    }
}
