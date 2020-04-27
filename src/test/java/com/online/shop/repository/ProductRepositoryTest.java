package com.online.shop.repository;

import lombok.*;
import com.online.shop.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Test
    void addOneProductToRepo() {

        Product testProduct = new Product();
        testProduct.setAcquisitionPrice(2.5);
        testProduct.setCurrentPrice(3.0);
        testProduct.setBarcode("918923471290");
        testProduct.setDescription("Some mock description");
        testProduct.setName("Product name");

        ProductRepository productRepository = new ProductRepository();
        productRepository.addOneProductToRepo(testProduct.getBarcode(), testProduct);
        assertEquals(productRepository.getProductHashMap().get(testProduct.getBarcode()).getFirst(), testProduct);

        //add a product with the same barcode
        Product testProduct2 = new Product();
        testProduct2.setAcquisitionPrice(2.3);
        testProduct2.setCurrentPrice(3.0);
        testProduct2.setBarcode("918923471290");
        testProduct2.setDescription("Some mock description");
        testProduct2.setName("Product name");

        productRepository.addOneProductToRepo(testProduct2.getBarcode(), testProduct2);
        assertEquals(productRepository.getProductHashMap().get(testProduct2.getBarcode()).size(),2);
        assertEquals(productRepository.getProductHashMap().get(testProduct2.getBarcode()).getFirst(),testProduct);
        assertEquals(productRepository.getProductHashMap().get(testProduct2.getBarcode()).get(1), testProduct2);
    }
}