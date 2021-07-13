
package com.certant.pokedex.service;

import com.certant.pokedex.dao.IPokemonDAO;
import com.certant.pokedex.domain.Pokemon;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PokemonServiceImplementation implements IPokemonService{
    
    @Autowired
    private IPokemonDAO pokemonDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Pokemon> listPokemons(){
        return (List<Pokemon>) pokemonDAO.findAll();
    }

    @Override
    public Pokemon save(Pokemon pokemon) {
                
        return pokemonDAO.save(pokemon);
    }


    public void deleteById(Long i) {
        pokemonDAO.deleteById(i);
    }
/*
    @Override
    public Pokemon find(Pokemon pokemon) {
        
        return pokemonDAO.findById(pokemon.getIdPokemon()).orElse(null);
    }*/

    @Override
    public Pokemon find(Long id) {
        return pokemonDAO.findById(id).orElse(null);
    }
}