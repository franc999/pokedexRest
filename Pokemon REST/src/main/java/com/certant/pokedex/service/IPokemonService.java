
package com.certant.pokedex.service;

import com.certant.pokedex.domain.Pokemon;
import java.util.List;

public interface IPokemonService {
    
    /* methods to implements */
    List<Pokemon> listPokemons();
    Pokemon save(Pokemon pokemon);
    public void deleteById(Long i);
    Pokemon find(Long i);
}
