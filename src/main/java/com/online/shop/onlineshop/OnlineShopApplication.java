package com.online.shop.onlineshop;

import com.online.shop.onlineshop.config.ConfigProperties;
import com.online.shop.onlineshop.model.Product;
import com.online.shop.onlineshop.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Slf4j
public class OnlineShopApplication implements CommandLineRunner {
	@Autowired
	ProductRepository productRepository;
	ConfigProperties configProperties;

	public OnlineShopApplication  (ProductRepository productRepository, ConfigProperties configProperties) {
		this.configProperties = configProperties;
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(OnlineShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
