package com.online.shop.onlineshop.model;

import com.online.shop.onlineshop.model.Product;
import com.online.shop.onlineshop.model.user.Client;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ClientOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @OneToMany(mappedBy = "clientOrder", cascade = CascadeType.ALL)
    private List <Product> productList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Client client;

    private LocalDate placedDate;
    private LocalDate dueDate;
    private String status;
    private String additionalInfo;

    public ClientOrder(Long orderId) {
        this.orderId = orderId;
    }
}
