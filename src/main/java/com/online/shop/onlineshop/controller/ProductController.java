package com.online.shop.onlineshop.controller;

import com.online.shop.onlineshop.model.dto.ProductRequestDTO;
import com.online.shop.onlineshop.model.dto.ProductResponseDTO;
import com.online.shop.onlineshop.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity saveProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO savedProduct = productService.save(productRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable String barcode) {
        ProductResponseDTO productToGet = productService.getProductResponseByBarcode(barcode);
        return ResponseEntity.status(HttpStatus.OK).body(productToGet);
    }

    @GetMapping
    public ResponseEntity getAllProducts() {
        List<ProductResponseDTO> productResponseDTOList = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDTOList);
    }
}
