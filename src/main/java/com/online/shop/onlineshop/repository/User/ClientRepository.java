package com.online.shop.onlineshop.repository.user;

import com.online.shop.onlineshop.model.user.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ClientRepository implements UserRepository {
    private HashMap<String, User> clientHashMap = new HashMap<>();


    public HashMap<String, User> getClientHashMap() {
        return clientHashMap;
    }

    public void setClientHashMap(HashMap<String, User> clientHashMap) {
        this.clientHashMap = clientHashMap;
    }

    @Override
    public void addUserToRepo(String id, User client) {
        this.clientHashMap.put(id, client);
    }

}