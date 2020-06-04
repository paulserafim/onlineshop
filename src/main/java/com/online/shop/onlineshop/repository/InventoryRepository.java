package com.online.shop.onlineshop.repository;

import com.online.shop.onlineshop.model.Inventory;
import com.online.shop.onlineshop.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {
    Inventory getInventoryById(Long id);
    Inventory getInventoryByProduct(Product product);
}
