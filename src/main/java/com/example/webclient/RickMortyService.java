package com.example.webclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RickMortyService {
    private WebClient client = WebClient.create();

    @Value("${api.url}")
    String url;

    @Value("${character.url}")
    String characterUrl;
//    private WebClient client = WebClient.create("https://rickandmortyapi.com/api");


    public List<RickMortyCharacter> getAllCharacter() {
        RickMortyResponseResults response = client
                .get()
//                .uri( url + "/character")
                .uri( url +characterUrl)
                .retrieve()
                .toEntity(RickMortyResponseResults.class)
                .block()
                .getBody();
        return response.getResults();
    }



    public List<RickMortyCharacter> getByStatus(String query) {
        RickMortyResponseResults rickAndMortyResponse
                = client.get()
                .uri(url +characterUrl + query)
                .retrieve()
                .toEntity(RickMortyResponseResults.class)
                .block()
                .getBody();
        return rickAndMortyResponse.getResults();
    }


}
