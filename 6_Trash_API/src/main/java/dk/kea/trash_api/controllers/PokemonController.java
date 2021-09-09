package dk.kea.trash_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PokemonController {

    List<String> pokemonList = Arrays.asList("Squirtle", "Snorlax", "Ninetales");

    @GetMapping("/pokemon/go")
    public boolean pokemonQuestionMark() {
        return true;
    }

    @GetMapping("/pokemon")
    public List pokemon() {
      return pokemonList;
    }
}
