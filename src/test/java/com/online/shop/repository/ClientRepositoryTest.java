package com.online.shop.repository;

import com.online.shop.model.User.Client;
import com.online.shop.repository.User.ClientRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientRepositoryTest {

    @Test
    void addClientToRepo() {
        Client testClient = new Client();
        testClient.setFirstName("Paul");
        testClient.setLastName("Serafim");
        testClient.setCity("Vaslui");
        testClient.setCountry("Romania");
        testClient.setCounty("Vaslui");
        testClient.setStreet("Crangului");
        testClient.setEmail("serafim.paul@gmail.com");
        testClient.setEncryptedPass("2c43r-c42rc4-234cr3c4");
        testClient.setHouseNumber("15");
        testClient.setPhoneNumber("0748380435");
        testClient.setId("1");
        testClient.setAge(26.5);

        ClientRepository clientRepository = new ClientRepository();
        clientRepository.getClientHashMap().put("1", testClient);
        assertEquals(clientRepository.getClientHashMap().size(),1);
        assertEquals(clientRepository.getClientHashMap().get("1"),testClient);
        assertTrue(testClient instanceof Client);
    }
}