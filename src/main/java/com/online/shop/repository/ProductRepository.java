package com.online.shop.repository;

import com.online.shop.model.Product;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class ProductRepository {
    private HashMap <String, LinkedList<Product>> productHashMap = new HashMap<>();

    public void addOneProductToRepo (String barcode, Product product) {
        if(productHashMap.containsKey(product.getBarcode())) {
            LinkedList<Product> productsOnBarcode = productHashMap.get(barcode);
            productsOnBarcode.add(product);
            productHashMap.put(barcode, productsOnBarcode);
        }
        else {
            LinkedList<Product> productsOnBarcode = new LinkedList<>();
            productsOnBarcode.add(product);
            productHashMap.put(barcode, productsOnBarcode);
        }
    }


    public HashMap<String, LinkedList<Product>> getProductHashMap() {
        return productHashMap;
    }

    public void setProductHashMap(HashMap<String, LinkedList<Product>> productHashMap) {
        this.productHashMap = productHashMap;
    }
}
