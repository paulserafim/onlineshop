package com.online.shop.onlineshop.controller.user;

import com.online.shop.onlineshop.OnlineShopApplication;
import com.online.shop.onlineshop.model.user.dto.ClientRequestDTO;
import com.online.shop.onlineshop.model.user.dto.ClientResponseDTO;
import com.online.shop.onlineshop.service.user.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineShopApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private ClientService clientService;

    private HttpHeaders headers = new HttpHeaders();

    @Test
    public void when_getClient_expect_200OK() {
        when(clientService.getClientResponseById(anyLong())).thenReturn(new ClientResponseDTO(31, "Paul", "Serafim"));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<ClientResponseDTO> responseEntity = testRestTemplate
                .exchange("http://localhost:" + port + "/client/31", HttpMethod.GET,
                        entity, ClientResponseDTO.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void when_saveClient_expect_201Created() throws URISyntaxException {
        final String url = "http://localhost:" + port + "/client";
        URI uri = new URI(url);
        ClientRequestDTO clientRequestDTO = new ClientRequestDTO("Alex", "Serafim");
        HttpEntity<ClientRequestDTO> request = new HttpEntity<>(clientRequestDTO, headers);
        ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(uri, request, String.class);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    public void when_getAllClients_expect_200OK() {
        when(clientService.getAllClients()).thenReturn(new ArrayList<>());
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<List<ClientResponseDTO>> responseEntity = testRestTemplate.exchange("http://localhost:" + port + "/client", HttpMethod.GET, entity, new ParameterizedTypeReference<List<ClientResponseDTO>>() {});

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}