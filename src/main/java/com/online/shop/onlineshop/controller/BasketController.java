package com.online.shop.onlineshop.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.online.shop.onlineshop.model.NegativeQuantityException;
import com.online.shop.onlineshop.model.dto.BasketRequestDTO;
import com.online.shop.onlineshop.model.dto.BasketResponseDTO;
import com.online.shop.onlineshop.model.dto.ProductResponseDTO;
import com.online.shop.onlineshop.service.BasketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/basket")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasketController {

    private BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping("/new")
    public ResponseEntity addNewBasket(@RequestBody BasketRequestDTO basketRequestDTO) {
        BasketResponseDTO savedBasket = null;
        try {
            savedBasket = basketService.save(basketRequestDTO);
        } catch (NegativeQuantityException e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBasket);

    }

    @GetMapping("/{id}")
    public ResponseEntity getBasketById(@PathVariable Long id) {
        BasketResponseDTO basketResponseDTO = basketService.getBasketById(id);
        return ResponseEntity.status(HttpStatus.OK).body(basketResponseDTO);
    }

}
