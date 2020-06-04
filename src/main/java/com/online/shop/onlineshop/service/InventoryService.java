package com.online.shop.onlineshop.service;

import com.online.shop.onlineshop.model.Basket;
import com.online.shop.onlineshop.model.Inventory;
import com.online.shop.onlineshop.model.NegativeQuantityException;
import com.online.shop.onlineshop.model.Product;
import com.online.shop.onlineshop.model.dto.InventoryRequestDTO;
import com.online.shop.onlineshop.model.dto.InventoryResponseDTO;
import com.online.shop.onlineshop.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InventoryService {
    private InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public InventoryResponseDTO save(InventoryRequestDTO inventory) {
        Inventory savedInventory = inventoryRepository.save(new Inventory(
                inventory.getProduct(),
                inventory.getQuantity()
                ));
        return new InventoryResponseDTO(
                savedInventory.getId(),
                savedInventory.getProduct().getName(),
                savedInventory.getProduct().getBarcode(),
                savedInventory.getQuantity()
        );
    }


    public InventoryResponseDTO getInventoryById(Long id) {
        Optional<Inventory> inventory = inventoryRepository.findById(id);

        return new InventoryResponseDTO(
                inventory.map(Inventory::getId).orElse(null),
                inventory.map(Inventory::getProduct).map(Product::getName).orElse(null),
                inventory.map(Inventory::getProduct).map(Product::getBarcode).orElse(null),
                inventory.map(Inventory::getQuantity).orElse(null));
    }

    public Inventory getInventoryByProduct(Product product) {
        return inventoryRepository.getInventoryByProduct(product);
    }

    public List<InventoryResponseDTO> getAllInventorys() {
        Iterable <Inventory> inventoryIterable = inventoryRepository.findAll();
        List<InventoryResponseDTO> inventoryResponseDTOList= new ArrayList<>();
        Iterator<Inventory> inventoryIterator = inventoryIterable.iterator();
        while (inventoryIterator.hasNext()) {
            Inventory inventory = inventoryIterator.next();
            inventoryResponseDTOList.add(new InventoryResponseDTO(
                    inventory.getId(),
                    inventory.getProduct().getName(),
                    inventory.getProduct().getBarcode(),
                    inventory.getQuantity()));
        }
        return inventoryResponseDTOList;
    }

    public boolean hasStock(Basket basket, InventoryService inventoryService) {
        basket.getBasketItems().forEach((item) -> {
            if(inventoryService.getInventoryByProduct(item.getProduct()).getQuantity() < item.getQuantity())
                throw new RuntimeException("You do not have enough stock for this basket");
        });
        return true;
    }


    public boolean hasStock(Product product, int quantity, InventoryService inventoryService) {
        if(inventoryService.getInventoryByProduct(product).getQuantity() < quantity)
            return false;
        else
            return true;
    }

    public void updateQuantity (Product product, int requiredQuantity) throws NegativeQuantityException {
        Inventory inventory = getInventoryByProduct(product);

        int quantity = inventory.getQuantity() - requiredQuantity;

        if(quantity < 0)
            throw new NegativeQuantityException("You have insufficient stock");

        inventory.setQuantity(inventory.getQuantity() - requiredQuantity);

        inventoryRepository.save(inventory);
    }
}
