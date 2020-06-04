package com.online.shop.onlineshop.controller;

import com.online.shop.onlineshop.model.ClientOrder;
import com.online.shop.onlineshop.model.dto.ClientOrderResponseDTO;
import com.online.shop.onlineshop.service.ClientOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/clientOrder")
public class ClientOrderController {

    private ClientOrderService clientOrderService;

    public ClientOrderController (ClientOrderService clientOrderService) {
        this.clientOrderService = clientOrderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getClientOrderById (@PathVariable Long orderId) {
        ClientOrderResponseDTO clientOrderResponseDTO = clientOrderService.getClientOrderById(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(clientOrderResponseDTO);
    }
}
