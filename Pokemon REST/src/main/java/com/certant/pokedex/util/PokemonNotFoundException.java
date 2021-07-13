
package com.certant.pokedex.util;

class PokemonNotFoundException extends RuntimeException{

    PokemonNotFoundException(Long id) {
        super("Could not find pokemon " + id);
    }
}
