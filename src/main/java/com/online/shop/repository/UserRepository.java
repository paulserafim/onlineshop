package com.online.shop.repository;

import com.online.shop.model.User.Client;
import com.online.shop.model.User.User;

public interface UserRepository {
    void addUserToRepo(String id, User user);

}
