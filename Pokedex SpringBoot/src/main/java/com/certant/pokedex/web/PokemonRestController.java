package com.certant.pokedex.web;

import com.certant.pokedex.domain.Pokemon;
import com.certant.pokedex.service.IPokemonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/pokemons")
@RestController
public class PokemonRestController {

    @Autowired(required=false)
    private IPokemonService pokemonService;

    @PostMapping(path = "/test", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<?> create(@RequestBody Pokemon pokemon,
                                    @RequestParam(value = "nType") String nType,
                                    @RequestParam(value = "nAbility") String nAbility) {

        pokemon = pokemonService.typeAndAbilitySaves(pokemon, nType, nAbility);

        if (pokemon.getAbilities() == null || pokemon.getTypes() == null || pokemon.getAbilities().isEmpty() || pokemon.getTypes().isEmpty()) {
            String message = "faltan datos";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        } else {

            return ResponseEntity.status(HttpStatus.CREATED).body(pokemonService.save(pokemon));
        }
    }
    
    // funciona pero no podes agregar nuevos //
    @PostMapping(path = "/add", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<Pokemon> test(Pokemon pokemon) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pokemonService.save(pokemon));
    }

    @GetMapping
    public List<Pokemon> list() {
        return pokemonService.listPokemons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> read(@PathVariable(value = "id") Long idPokemon) {
        Pokemon pok = pokemonService.find(idPokemon);

        if (pok == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pok);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pokemon> deletePokemon(@PathVariable(value = "id") Long idPokemon) {
        Pokemon pok = pokemonService.find(idPokemon);

        if (pok == null) {
            return ResponseEntity.notFound().build();
        }

        pokemonService.deleteById(idPokemon);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pokemon> update(@RequestBody Pokemon pokemon, @PathVariable(value = "id") Long idPokemon
    ) {
        Pokemon pok = pokemonService.find(idPokemon);

        if (pok == null) {
            return ResponseEntity.notFound().build();
        }

        pok.setName(pokemon.getName());
        pok.setLevel(pokemon.getLevel());
        pok.setTypes(pokemon.getTypes());
        pok.setAbilities(pokemon.getAbilities());
        pok.setEvolutions(pokemon.getEvolutions());

        return ResponseEntity.status(HttpStatus.CREATED).body(pokemonService.save(pok));
    }
}
