package com.online.shop.onlineshop.repository;

import com.online.shop.onlineshop.config.DataProperties;
import com.online.shop.onlineshop.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.Null;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {


    @Test
    void addOneProductToRepo() throws URISyntaxException {
        ProductRepository productRepository = new ProductRepository();
        Path path = Paths.get(getClass().getClassLoader().getResource("testdata.txt").toURI());
        productRepository.loadFromFile(path.toString());
        productRepository.addOneProductToRepo("123456789", new Product("Mockname", 2.0));
        assertTrue(productRepository.getProductHashMap().containsKey("123456789"));
        assertEquals(productRepository.getProductHashMap().get("123456789").getFirst().getName().compareTo("Mockname"), 0);
        assertTrue(productRepository.getProductHashMap().get("123456789") instanceof List);


    }

    @Test
    void loadFromFile() throws URISyntaxException {
        ProductRepository productRepository = new ProductRepository();
        Path path = Paths.get(getClass().getClassLoader().getResource("testdata.txt").toURI());
        productRepository.loadFromFile(path.toString());
        assertTrue(productRepository.getProductHashMap().containsKey("8695122005662"));
    }

    @Test
    void addProductByQuantity() throws URISyntaxException{
        ProductRepository productRepository = new ProductRepository();
        Path path = Paths.get(getClass().getClassLoader().getResource("testdata.txt").toURI());
        productRepository.loadFromFile(path.toString());
        productRepository.addProductByQuantity("123456789", new Product("Mockname", 2.0), 5);
        assertTrue(productRepository.getProductHashMap().containsKey("123456789"));
        assertEquals(productRepository.getProductHashMap().get("123456789").size(), 5);
        assertEquals(productRepository.getProductHashMap().get("123456789").getFirst().getName().compareTo("Mockname"), 0);
        assertTrue(productRepository.getProductHashMap().get("123456789") instanceof List);
    }
}