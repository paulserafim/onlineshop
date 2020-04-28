package com.online.shop.onlineshop.repository;

import com.online.shop.onlineshop.model.user.Order;
import lombok.*;

import java.util.HashMap;
import java.util.LinkedList;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class OrderRepository {
    private HashMap<Long, Order> orderHashMap = new HashMap<>();

    public void addOneOrderToRepo (long id, Order order) {
        orderHashMap.put(id, order);
    }

    public Order getOrderById(long id) {
        if(orderHashMap.containsKey(id))
            return orderHashMap.get(id);
        else
            throw new NullPointerException("Order number:" + id  + "does not exist.");
    }
}
