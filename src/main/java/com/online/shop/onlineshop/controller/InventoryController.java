package com.online.shop.onlineshop.controller;

import com.online.shop.onlineshop.model.dto.InventoryRequestDTO;
import com.online.shop.onlineshop.model.dto.InventoryResponseDTO;
import com.online.shop.onlineshop.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/inventory")
public class InventoryController {
    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public ResponseEntity saveInventory(@RequestBody InventoryRequestDTO inventoryRequestDTO) {
        InventoryResponseDTO savedInventory = inventoryService.save(inventoryRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInventory);
    }

    @GetMapping("/{id}")
    public ResponseEntity getInventory(@PathVariable Long id) {
        InventoryResponseDTO inventoryToGet = inventoryService.getInventoryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(inventoryToGet);
    }

    @GetMapping
    public ResponseEntity getAllInventorys() {
        List<InventoryResponseDTO> inventoryResponseDTOList = inventoryService.getAllInventorys();
        return ResponseEntity.status(HttpStatus.OK).body(inventoryResponseDTOList);
    }
}
