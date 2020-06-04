package com.online.shop.onlineshop.service.user;

import com.online.shop.onlineshop.model.user.Client;
import com.online.shop.onlineshop.model.user.dto.ClientRequestDTO;
import com.online.shop.onlineshop.model.user.dto.ClientResponseDTO;
import com.online.shop.onlineshop.repository.user.ClientRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientResponseDTO save(ClientRequestDTO clientRequestDTO) {
        Client savedClient = clientRepository.save(new Client(
                clientRequestDTO.getFirstName(),
                clientRequestDTO.getLastName(),
                clientRequestDTO.getEmail(),
                clientRequestDTO.getCity(),
                clientRequestDTO.getCounty(),
                clientRequestDTO.getCountry(),
                clientRequestDTO.getStreet(),
                clientRequestDTO.getHouseNumber(),
                clientRequestDTO.getEncryptedPass(),
                clientRequestDTO.getAge(),
                clientRequestDTO.getPhoneNumber()));

        return new ClientResponseDTO(
                savedClient.getFirstName(),
                savedClient.getLastName(),
                savedClient.getEmail(),
                savedClient.getCity(),
                savedClient.getCounty(),
                savedClient.getCountry(),
                savedClient.getStreet(),
                savedClient.getHouseNumber(),
                savedClient.getId(),
                savedClient.getAge(),
                savedClient.getPhoneNumber()
        );
    }

    public ClientResponseDTO getClientResponseById(Long id) {
        Optional<Client> client = clientRepository.findById(id);

        return new ClientResponseDTO(
                client.map(Client::getFirstName).orElse(null),
                client.map(Client::getLastName).orElse(null),
                client.map(Client::getEmail).orElse(null),
                client.map(Client::getCity).orElse(null),
                client.map(Client::getCounty).orElse(null),
                client.map(Client::getCountry).orElse(null),
                client.map(Client::getStreet).orElse(null),
                client.map(Client::getHouseNumber).orElse(null),
                client.map(Client::getId).orElse(null),
                client.map(Client::getAge).orElse(null),
                client.map(Client::getPhoneNumber).orElse(null)
        );
    }


    public List<ClientResponseDTO> getAllClients() {
        Iterable <Client> clientIterable = clientRepository.findAll();
        List<ClientResponseDTO> clientResponseDTOList= new ArrayList<>();
        Iterator<Client> clientIterator = clientIterable.iterator();
        while (clientIterator.hasNext()) {
            Client client = clientIterator.next();
            clientResponseDTOList.add(new ClientResponseDTO(
                    client.getFirstName(),
                    client.getLastName(),
                    client.getEmail(),
                    client.getCity(),
                    client.getCounty(),
                    client.getCountry(),
                    client.getStreet(),
                    client.getHouseNumber(),
                    client.getId(),
                    client.getAge(),
                    client.getPhoneNumber()
            ));
        }
        return clientResponseDTOList;
    }

    public Client getClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }
}
