package com.online.shop.onlineshop.service;

import com.online.shop.onlineshop.model.BasketItem;
import com.online.shop.onlineshop.repository.BasketItemRepository;
import org.springframework.stereotype.Service;

@Service
public class BasketItemService {

    private BasketItemRepository basketItemRepository;

    public BasketItemService (BasketItemRepository basketItemRepository) {
        this.basketItemRepository = basketItemRepository;
    }

    public BasketItem save(BasketItem basketItem) {
        return basketItemRepository.save(basketItem);
    }
}
