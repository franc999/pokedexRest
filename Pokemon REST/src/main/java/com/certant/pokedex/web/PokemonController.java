
package com.certant.pokedex.web;

import com.certant.pokedex.domain.Pokemon;
import com.certant.pokedex.service.IAbilityService;
import com.certant.pokedex.service.IPokemonService;
import com.certant.pokedex.service.ITypeService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class PokemonController {
    
    @Autowired
    private IPokemonService pokemonService;
    
    @Autowired
    private ITypeService typeService;
    
    @Autowired
    private IAbilityService abilityService;
    
    @GetMapping("/addPokemon")
    public String addPokemon(Pokemon pokemon, Model model){
        
        var types = typeService.listTypes();
        var abilities = abilityService.listAbilities();

        model.addAttribute("types", types);
        model.addAttribute("abilities", abilities);
        
        return "layout/addPokemon";
    }
    
    @PostMapping("/save") 
    public String save (@Valid Pokemon pokemon, Errors error){
        
        if(error.hasErrors()){
            return "index";
        }

        pokemonService.save(pokemon);
        return "index";
    }
    
    @GetMapping("/listPokemon")
    public String listPokemon(Model model){
        
        var pokemons = pokemonService.listPokemons();
        
        model.addAttribute("pokemons", pokemons);
        
        return "layout/listPokemon";
    }
}
