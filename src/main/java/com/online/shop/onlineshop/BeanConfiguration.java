package com.online.shop.onlineshop;

import com.online.shop.onlineshop.config.DataProperties;
import com.online.shop.onlineshop.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Configuration

public class BeanConfiguration {
    @Autowired
    DataProperties dataProperties;

    @Bean
    public ProductRepository productRepository() throws URISyntaxException {
        ProductRepository productRepository = new ProductRepository();
        Path path = Paths.get(getClass().getClassLoader().getResource(dataProperties.getProductDataPath()).toURI());
        productRepository.loadFromFile(path.toString());
        return productRepository;
    }
}
