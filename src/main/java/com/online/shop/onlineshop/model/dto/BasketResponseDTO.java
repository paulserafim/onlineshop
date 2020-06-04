package com.online.shop.onlineshop.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.online.shop.onlineshop.model.BasketItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasketResponseDTO {
    private Long id;
    private Long clientId;
    private Long clientOrderId;
    private List <BasketItemResponseDTO> basketItems;

    public BasketResponseDTO (Long id, Long clientId, List<BasketItemResponseDTO> basketItems) {
        this.id = id;
        this.clientId = clientId;
        this.basketItems = basketItems;
    }

    public BasketResponseDTO (Long id, List<BasketItemResponseDTO> basketItems) {
        this.id = id;
        this.basketItems = basketItems;
    }

}
