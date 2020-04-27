package com.online.shop.onlineshop.repository.user;

import com.online.shop.onlineshop.model.user.User;

public interface UserRepository {
    void addUserToRepo(String id, User user);

}
