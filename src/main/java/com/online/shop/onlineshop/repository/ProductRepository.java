package com.online.shop.onlineshop.repository;

import com.online.shop.onlineshop.model.Product;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Slf4j
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

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

    public void retrieveFromRepo(List<Product> retrieveOrderList) {

        HashMap <String, Integer> frequency = new HashMap<>();

        for(Product product:retrieveOrderList) {
            if (productHashMap.containsKey(product.getBarcode())) {
                if(frequency.containsKey(product.getBarcode()))
                    frequency.put(product.getBarcode(), frequency.get(product.getBarcode()) + 1);
                else
                    frequency.put(product.getBarcode(), 1);
            }
            else
                throw new NullPointerException("The product:" + product.getBarcode() +" does not exist in your database");
        }

        for(Map.Entry<String, Integer> entry: frequency.entrySet()) {
            if (entry.getValue() > productHashMap.get(entry.getKey()).size())
                throw new RuntimeException("You have not enough stock");
            else {
            }
        }

        for(Map.Entry<String,Integer> entry:frequency.entrySet()) {
            for(int index = 0; index < entry.getValue(); index++) {
                productHashMap.get(entry.getKey()).removeLast();
            }
        }


/*

        for(Product product:retrieveOrderList) {
            int productOccurrence = 0;
            if(productHashMap.containsKey(product.getBarcode())) {
                for(int index = 0; index < retrieveOrderList.size(); index++)
                    if(retrieveOrderList.get(index).getBarcode().compareTo(product.getBarcode()) == 0)
                        productOccurrence ++;

                if (productHashMap.get(product.getBarcode()).size() >= productOccurrence) {
                        productHashMap.get(product.getBarcode()).removeLast();
                }
                else {
                    throw new NullPointerException("You have not enough stock for product: " + product.getBarcode());
                }
            }
            else throw new NullPointerException("The product:" + product.getBarcode() +" does not exist in your database");
        }

 */
    }
}
