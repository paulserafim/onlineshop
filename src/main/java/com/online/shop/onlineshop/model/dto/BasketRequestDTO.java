package com.online.shop.onlineshop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasketRequestDTO {

    private Long clientId;
    private Long clientOrderId;
    private List<BasketItemRequestDTO> basketItems;

    public BasketRequestDTO (Long clientId, List<BasketItemRequestDTO> basketItems) {
        this.clientId = clientId;
        this.basketItems = basketItems;
    }
}