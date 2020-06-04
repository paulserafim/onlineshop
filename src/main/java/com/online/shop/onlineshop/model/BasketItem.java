package com.online.shop.onlineshop.model;

import com.online.shop.onlineshop.model.dto.BasketItemResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BasketItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn
    private Product product;
    private int quantity;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn
    private Basket basket;

    public BasketItem(Product product, int quantity, Basket basket) {
        this.product = product;
        this.quantity = quantity;
        this.basket = basket;
    }

    public BasketItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
