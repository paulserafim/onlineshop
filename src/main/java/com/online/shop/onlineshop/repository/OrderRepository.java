package com.online.shop.onlineshop.repository;

import com.online.shop.onlineshop.model.user.Order;

import java.util.HashMap;
import java.util.LinkedList;

public class OrderRepository {
    private HashMap<String, LinkedList<Order>> orderHashMap = new HashMap<>();

    public void addOneOrderToRepo (String date, Order order) {
        if(orderHashMap.containsKey(date)) {
            LinkedList<Order> ordersOnDate = orderHashMap.get(date);
            ordersOnDate.add(order);
            orderHashMap.put(date, ordersOnDate);
        }
        else {
            LinkedList<Order> ordersOnDate = new LinkedList<>();
            ordersOnDate.add(order);
            orderHashMap.put(order.getPlacedDate().toString(), ordersOnDate);
        }
    }

    public HashMap<String, LinkedList<Order>> getOrderHashMap() {
        return orderHashMap;
    }

    public void setOrderHashMap(HashMap<String, LinkedList<Order>> orderHashMap) {
        this.orderHashMap = orderHashMap;
    }
}
