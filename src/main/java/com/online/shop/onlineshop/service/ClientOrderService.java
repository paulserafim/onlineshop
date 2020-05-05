package com.online.shop.onlineshop.service;

import com.online.shop.onlineshop.model.ClientOrder;
import com.online.shop.onlineshop.repository.ClientOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientOrderService {

    private ClientOrderRepository clientOrderRepository;

    public ClientOrderService(ClientOrderRepository clientOrderRepository) {
        this.clientOrderRepository = clientOrderRepository;
    }

    public ClientOrder save(ClientOrder clientOrder) {
        clientOrderRepository.save(clientOrder);
        return clientOrder;
    }
}
