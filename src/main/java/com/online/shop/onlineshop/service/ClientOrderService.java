package com.online.shop.onlineshop.service;

import com.online.shop.onlineshop.model.Basket;
import com.online.shop.onlineshop.model.BasketItem;
import com.online.shop.onlineshop.model.ClientOrder;
import com.online.shop.onlineshop.model.dto.BasketItemResponseDTO;
import com.online.shop.onlineshop.model.dto.BasketResponseDTO;
import com.online.shop.onlineshop.model.dto.ClientOrderResponseDTO;
import com.online.shop.onlineshop.model.dto.ProductResponseDTO;
import com.online.shop.onlineshop.model.user.dto.ClientResponseDTO;
import com.online.shop.onlineshop.repository.ClientOrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientOrderService {

    private ClientOrderRepository clientOrderRepository;
    private BasketService basketService;

    public ClientOrderService(ClientOrderRepository clientOrderRepository, BasketService basketService) {
        this.clientOrderRepository = clientOrderRepository;
        this.basketService = basketService;
    }

    public ClientOrder save(ClientOrder clientOrder) {
        clientOrderRepository.save(clientOrder);
        return clientOrder;
    }


    public ClientOrderResponseDTO getClientOrderById(Long orderId) {
        ClientOrder clientOrder = clientOrderRepository.getOrderByOrderId(orderId);
        Basket basket = basketService.getBasketByClientOrderDAO(clientOrder);

        List<BasketItem> basketItems = basket.getBasketItems();
        List<BasketItemResponseDTO> basketItemResponseDTOList = new ArrayList<>();

        basketItems.forEach(
                element -> {
                    basketItemResponseDTOList.add(
                            new BasketItemResponseDTO(
                                    element.getId(),
                                    new ProductResponseDTO(
                                            element.getProduct().getBarcode(),
                                            element.getProduct().getName(),
                                            element.getProduct().getCurrentPrice()
                                    ),
                                    element.getQuantity(),
                                    element.getBasket().getId()
                            )
                    );
                }
        );



        return new ClientOrderResponseDTO(
                clientOrder.getOrderId(),
                new ClientResponseDTO(
                        clientOrder.getClient().getFirstName(),
                        clientOrder.getClient().getLastName(),
                        clientOrder.getClient().getEmail(),
                        clientOrder.getClient().getCity(),
                        clientOrder.getClient().getCounty(),
                        clientOrder.getClient().getCountry(),
                        clientOrder.getClient().getStreet(),
                        clientOrder.getClient().getHouseNumber(),
                        clientOrder.getClient().getId(),
                        clientOrder.getClient().getAge(),
                        clientOrder.getClient().getPhoneNumber()
                ),
                clientOrder.getPlacedDate(),
                clientOrder.getDueDate(),
                clientOrder.getStatus(),
                clientOrder.getAdditionalInfo(),
                new BasketResponseDTO(
                    clientOrder.getBasket().getId(),
                        basketItemResponseDTOList
                )
                        );
    }
}
