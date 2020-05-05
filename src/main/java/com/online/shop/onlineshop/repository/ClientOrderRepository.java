package com.online.shop.onlineshop.repository;

import com.online.shop.onlineshop.model.ClientOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientOrderRepository extends CrudRepository<ClientOrder, Long> {
    ClientOrder getOrderByOrderId(long id);
}
