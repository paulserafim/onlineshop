package com.online.shop.onlineshop.repository;

import com.online.shop.onlineshop.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
    List<Product> getProductByBarcode(String barcode);

}
