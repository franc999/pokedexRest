
package com.certant.pokedex.service;

import com.certant.pokedex.dao.IPokemonDAO;
import com.certant.pokedex.domain.Ability;
import com.certant.pokedex.domain.Pokemon;
import com.certant.pokedex.domain.Type;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PokemonServiceImplementation implements IPokemonService{
    
    @Autowired
    private IPokemonDAO pokemonDAO;
    
    @Autowired
    private ITypeService typeService;

    @Autowired
    private IAbilityService abilityService;
        
    @Override
    @Transactional(readOnly = true)
    public List<Pokemon> listPokemons(){
        return pokemonDAO.findAll();
    }

    @Override
    public Pokemon save(Pokemon pokemon) {
                
        return pokemonDAO.save(pokemon);
    }
    
    @Override
    public Pokemon find(Long i) {
        
        return pokemonDAO.findById(i).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        pokemonDAO.deleteById(id);
    }

    public Pokemon typeAndAbilitySaves(Pokemon pokemon, String nType, String nAbility) {
        
        if (!nType.isEmpty() && nType != null && !nAbility.isEmpty() && nAbility != null) {
            
            Type aux = new Type();
            aux.setType(nType);
            Type newType = typeService.save(aux);

            Ability auxAb = new Ability();
            auxAb.setAbility(nAbility);
            Ability newAbility = abilityService.save(auxAb);
            
            pokemon.addType(newType);
            pokemon.addAbility(newAbility);
        }
        return pokemon;
    }
    
    public Pokemon addTypeAndAbilityOfEvolution(Pokemon pokemon, Pokemon evolution){
        
        for(Ability ability : evolution.getAbilities()){
            pokemon.addAbility(ability);
        }
        for(Type type : evolution.getTypes()){
            pokemon.addType(type);
        }
        return pokemon;
    }

    @Override
    public void delete(Pokemon pokemon) {
        pokemonDAO.delete(pokemon);
    }
}
