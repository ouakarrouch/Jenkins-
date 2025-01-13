package com.example.client.services;


import com.example.client.entities.Car;
import com.example.client.entities.Client;
import com.example.client.modeles.ClientResponse;
import com.example.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ClientServiceWebClient {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public ClientResponse getClientById(Long id) throws Exception {
        Client client = clientRepository.findById(id).orElseThrow(() -> new Exception("Invalid Client ID"));
        List<Car> cars = webClientBuilder.build()
                .get()
                .uri("http://localhost:8888/SERVICE-CAR/api/car/client/" + id)
                .retrieve()
                .bodyToFlux(Car.class)
                .collectList()
                .block();
        client.setCars(cars);
        return new ClientResponse(client);
    }
}
