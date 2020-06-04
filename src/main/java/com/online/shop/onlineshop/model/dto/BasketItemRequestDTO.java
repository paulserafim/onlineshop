package com.online.shop.onlineshop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketItemRequestDTO {
    private ProductRequestDTO product;
    private int quantity;
    private Long basketId;

    public BasketItemRequestDTO(ProductRequestDTO product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
