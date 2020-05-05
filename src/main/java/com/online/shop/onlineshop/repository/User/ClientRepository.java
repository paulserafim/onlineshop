package com.online.shop.onlineshop.repository.user;

import com.online.shop.onlineshop.model.user.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> getClientByFirstName(String firstName);
    List<Client> getClientByLastName(String lastName);
    Client getClientById(Long id);

}
