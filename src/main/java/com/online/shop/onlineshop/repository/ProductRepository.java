package com.online.shop.onlineshop.repository;

import com.online.shop.onlineshop.model.Product;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Slf4j
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

    public void loadFromFile(String path) {
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitArray = line.split("\t");
                this.addProductByQuantity(splitArray[0], new Product(splitArray[3], Double.parseDouble(splitArray[2])), Integer.parseInt(splitArray[1]));
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }

    public void addProductByQuantity(String barcode, Product product, double quantity) {
        {
            if(productHashMap.containsKey(product.getBarcode())) {
                LinkedList<Product> productsOnBarcode = productHashMap.get(barcode);
                for (int index = 0; index < quantity; index++) {
                    product.setBarcode(barcode);
                    productsOnBarcode.add(product);
                }
                productHashMap.put(barcode, productsOnBarcode);
                log.info(productHashMap.get(barcode).toString());
            }
            else {
                LinkedList<Product> productsOnBarcode = new LinkedList<>();
                for (int index = 0; index < quantity; index++) {
                    product.setBarcode(barcode);
                    productsOnBarcode.add(product);
                }
                productHashMap.put(barcode, productsOnBarcode);
                for(int index = 0; index < productHashMap.get(barcode).size(); index++)
                    log.info("Product:" + productHashMap.get(barcode).get(index).toString());
            }
        }
    }

    public LinkedList<Product> getProductsByBarcode(String barcode) {
        if(productHashMap.containsKey(barcode))
            return productHashMap.get(barcode);
        else
            throw new NullPointerException("The product:" + barcode +" does not exist in your database");
    }

    public Product getProductByBarcode (String barcode) {
        if(productHashMap.containsKey(barcode))
            return productHashMap.get(barcode).getFirst();
        else
            throw new NullPointerException("The product:" + barcode +" does not exist in your database");
    }
}
