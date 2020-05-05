package com.online.shop.onlineshop.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product implements Comparable<Product>{
    private String name, description;

    @Id
    private String barcode;
    private double currentPrice, acquisitionPrice;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @JoinColumn
    private Inventory inventory;

    @ManyToOne
    @JoinColumn
    private ClientOrder clientOrder;

    public Product(String name, double currentPrice) {
        this.name = name;
        this.currentPrice = currentPrice;
    }

    public Product(String name, String description, String barcode, double currentPrice, double acquisitionPrice) {
        this.name = name;
        this.description = description;
        this.barcode = barcode;
        this.currentPrice= currentPrice;
        this.acquisitionPrice = acquisitionPrice;
    }



    public Product(String barcode, double currentPrice, String name) {
        this.barcode = barcode;
        this.currentPrice = currentPrice;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", barcode='" + barcode + '\'' +
                ", currentPrice=" + currentPrice +
                ", acquisitionPrice=" + acquisitionPrice +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return this.getBarcode().compareTo(o.getBarcode());
    }
}