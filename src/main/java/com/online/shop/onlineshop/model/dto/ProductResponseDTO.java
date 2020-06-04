package com.online.shop.onlineshop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductResponseDTO {
    private String name;
    private String description;
    private String barcode;
    private double currentPrice;

    public ProductResponseDTO(String name, String barcode, double currentPrice) {
        this.name = name;
        this.barcode = barcode;
        this.currentPrice = currentPrice;
    }
}
