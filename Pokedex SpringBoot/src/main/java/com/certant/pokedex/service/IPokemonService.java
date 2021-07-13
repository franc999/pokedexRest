
package com.certant.pokedex.service;

import com.certant.pokedex.domain.Pokemon;
import java.util.List;
import java.util.Optional;

public interface IPokemonService {
    
    List<Pokemon> listPokemons();
    Pokemon save(Pokemon pokemon);
    public void deleteById(Long i);
    Pokemon find(Long i);
    Pokemon typeAndAbilitySaves(Pokemon pokemon, String nType, String nAbility);
    Pokemon addTypeAndAbilityOfEvolution(Pokemon pokemon, Pokemon evolution);

    public void delete(Pokemon pokemon);
}
