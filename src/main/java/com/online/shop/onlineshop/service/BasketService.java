package com.online.shop.onlineshop.service;

import com.online.shop.onlineshop.model.Basket;
import com.online.shop.onlineshop.model.BasketItem;
import com.online.shop.onlineshop.model.ClientOrder;
import com.online.shop.onlineshop.model.NegativeQuantityException;
import com.online.shop.onlineshop.model.dto.BasketItemResponseDTO;
import com.online.shop.onlineshop.model.dto.BasketRequestDTO;
import com.online.shop.onlineshop.model.dto.BasketResponseDTO;
import com.online.shop.onlineshop.model.dto.ProductResponseDTO;
import com.online.shop.onlineshop.repository.BasketItemRepository;
import com.online.shop.onlineshop.repository.BasketRepository;
import com.online.shop.onlineshop.service.user.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.online.shop.onlineshop.model.user.Client;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BasketService {
    private BasketRepository basketRepository;
    private ClientService clientService;
    private ProductService productService;
    private BasketItemService basketItemService;
    private InventoryService inventoryService;

    public BasketService(BasketRepository basketRepository, ClientService clientService, ProductService productService, BasketItemService basketItemService, InventoryService inventoryService) {
        this.basketRepository = basketRepository;
        this.clientService = clientService;
        this.productService = productService;
        this.basketItemService = basketItemService;
        this.inventoryService = inventoryService;
    }

    public Basket save(Basket basket) {
        Basket savedBasket = basketRepository.save(basket);
        return savedBasket;
    }

    public Basket getBasketByClientOrderDAO (ClientOrder clientOrder){
        return basketRepository.getBasketByClientOrder(clientOrder);
    }

    public BasketResponseDTO save(BasketRequestDTO basketRequestDTO) throws NegativeQuantityException{
        Client client = clientService.getClientById(basketRequestDTO.getClientId());
        List<BasketItem> basketItems = new ArrayList<BasketItem>();
        List<BasketItemResponseDTO> basketItemsResponseDTOS = new ArrayList<BasketItemResponseDTO>();

        basketRequestDTO.getBasketItems().forEach(
                element -> {
                    basketItems.add(new BasketItem(
                            productService.getProductByBarcode(element.getProduct().getBarcode()),
                            element.getQuantity()
                    ));
                }
        );
        Basket basket = basketRepository.save(new Basket(
                client,
                basketItems
        ));
        basketItems.forEach(
                element -> {
                    element.setBasket(basket);
                    try {
                        inventoryService.updateQuantity(element.getProduct(), element.getQuantity());
                        BasketItem basketItem = basketItemService.save(element);

                        basketItemsResponseDTOS.add(
                                new BasketItemResponseDTO(
                                        basketItem.getId(),
                                        new ProductResponseDTO(
                                                basketItem.getProduct().getName(),
                                                basketItem.getProduct().getDescription(),
                                                basketItem.getProduct().getBarcode(),
                                                basketItem.getProduct().getCurrentPrice()
                                        ),
                                        basketItem.getQuantity(),
                                        basketItem.getBasket().getId()
                                )
                        );

                    } catch (NegativeQuantityException e) {
                        System.err.println(e.getMessage());
                    }
                }
        );

        return new BasketResponseDTO(
                basket.getId(),
                basket.getClient().getId(),
                basketItemsResponseDTOS
        );
    }

    public BasketResponseDTO getBasketById(Long id) {
        Basket basket = basketRepository.getBasketById(id);
        List<BasketItemResponseDTO> basketItemResponseDTOList = new ArrayList<BasketItemResponseDTO>();

        basket.getBasketItems().forEach(
                element -> {
                    ProductResponseDTO productResponseDTO = new ProductResponseDTO(
                            element.getProduct().getName(),
                            element.getProduct().getDescription(),
                            element.getProduct().getBarcode(),
                            element.getProduct().getCurrentPrice()
                    );
                    basketItemResponseDTOList.add(
                            new BasketItemResponseDTO(
                                    element.getId(),
                                    productResponseDTO,
                                    element.getQuantity(),
                                    element.getBasket().getId()
                            )
                    );
                }
        );

        return new BasketResponseDTO(
                basket.getId(),
                basket.getClient().getId(),
                basketItemResponseDTOList
        );
    }
}
