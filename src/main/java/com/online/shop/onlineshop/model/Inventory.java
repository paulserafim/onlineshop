package com.online.shop.onlineshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
    private int quantity;

    public Inventory(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        return id.intValue();
    }
}
