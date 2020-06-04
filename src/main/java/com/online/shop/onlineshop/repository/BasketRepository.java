package com.online.shop.onlineshop.repository;

import com.online.shop.onlineshop.model.Basket;
import com.online.shop.onlineshop.model.ClientOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends CrudRepository <Basket, Long> {
    Basket getBasketById(long id);
    Basket getBasketByClientOrder(ClientOrder clientOrder);
}
