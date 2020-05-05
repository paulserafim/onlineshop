package com.online.shop.onlineshop.model.dto;

import com.online.shop.onlineshop.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventoryResponseDTO {
    Long id;
    String productName;
    String barcode;
    int quantity;
}
