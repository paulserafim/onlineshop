package com.online.shop.onlineshop.repository;

import com.online.shop.onlineshop.model.BasketItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketItemRepository extends CrudRepository<BasketItem, Long> {
    BasketItem getBasketItemById(Long id);
}
