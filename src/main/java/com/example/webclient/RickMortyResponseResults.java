package com.example.webclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RickMortyResponseResults {
    List<RickMortyCharacter> results;

}
