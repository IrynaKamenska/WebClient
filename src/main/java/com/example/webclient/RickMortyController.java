package com.example.webclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RickMortyController {
    RickMortyService rickMortyService;

    public RickMortyController(RickMortyService rickMortyService) {
        this.rickMortyService = rickMortyService;
    }

    // http://localhost:8080/api/
    @GetMapping
    public List<RickMortyCharacter> getAllCharacter() {
        return rickMortyService.getAllCharacter();
    }

    // http://localhost:8080/api/byStatus/?status=alive
    @GetMapping(path = "/byStatus/")
    public List<RickMortyCharacter> getAllCharacters(@RequestParam Map<String, String> status) {
        String completeQuery = "?" + status
                .entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("&"));
        return rickMortyService.getByStatus(completeQuery);

    }
}
