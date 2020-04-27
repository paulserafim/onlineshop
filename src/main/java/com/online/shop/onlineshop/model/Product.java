package com.online.shop.onlineshop.model;

import lombok.*;

import java.awt.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter

public class Product {
    private String name, description, barcode;
    private Image image;
    private double currentPrice, acquisitionPrice;


    public Product(String name, double currentPrice) {
        this.name = name;
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", barcode='" + barcode + '\'' +
                ", image=" + image +
                ", currentPrice=" + currentPrice +
                ", acquisitionPrice=" + acquisitionPrice +
                '}';
    }
}