package com.online.shop.onlineshop.service;

import com.online.shop.onlineshop.model.Inventory;
import com.online.shop.onlineshop.model.Product;
import com.online.shop.onlineshop.model.dto.InventoryRequestDTO;
import com.online.shop.onlineshop.model.dto.InventoryResponseDTO;
import com.online.shop.onlineshop.model.dto.ProductResponseDTO;
import com.online.shop.onlineshop.model.user.Client;
import com.online.shop.onlineshop.model.user.dto.ClientResponseDTO;
import com.online.shop.onlineshop.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
}
