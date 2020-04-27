package com.online.shop.onlineshop.model;

import lombok.*;

import java.awt.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter

public class Product {
    private String name, description, barcode;
    private Image image;
    private double currentPrice, acquisitionPrice;

    public Product() {};

    public Product(String name, double currentPrice) {
        this.name = name;
        this.currentPrice = currentPrice;
    }
}