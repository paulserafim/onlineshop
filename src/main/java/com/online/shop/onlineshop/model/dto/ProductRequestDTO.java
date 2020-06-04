package com.online.shop.onlineshop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductRequestDTO {
    private String name;
    private String description;
    private String barcode;
    private double currentPrice;
    private double acquisitionPrice;

    public ProductRequestDTO(String name, String barcode, double currentPrice, double acquisitionPrice) {
        this.name = name;
        this.barcode = barcode;
        this.currentPrice = currentPrice;
        this.acquisitionPrice = acquisitionPrice;
    }
}
