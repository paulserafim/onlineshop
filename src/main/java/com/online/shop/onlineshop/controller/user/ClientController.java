package com.online.shop.onlineshop.controller.user;

import com.online.shop.onlineshop.model.user.Client;
import com.online.shop.onlineshop.model.user.dto.ClientRequestDTO;
import com.online.shop.onlineshop.model.user.dto.ClientResponseDTO;
import com.online.shop.onlineshop.service.user.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity saveClient(@RequestBody ClientRequestDTO clientRequestDTO) {
        ClientResponseDTO savedClient = clientService.save(clientRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    @GetMapping("/{id}")
    public ResponseEntity getClient(@PathVariable Long id) {
        ClientResponseDTO clientToGet = clientService.getClientById(id);
        return ResponseEntity.status(HttpStatus.OK).body(clientToGet);
    }

    @GetMapping
    public ResponseEntity getAllClients() {
        List<ClientResponseDTO> clientResponseDTOList = clientService.getAllClients();
        return ResponseEntity.status(HttpStatus.OK).body(clientResponseDTOList);
    }
}
