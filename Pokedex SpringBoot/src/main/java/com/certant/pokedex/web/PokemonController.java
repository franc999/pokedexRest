package com.certant.pokedex.web;

import com.certant.pokedex.domain.Pokemon;
import com.certant.pokedex.domain.Type;
import com.certant.pokedex.domain.Ability;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class PokemonController {

    @Autowired
    private IPokemonService pokemonService;

    @Autowired
    private ITypeService typeService;

    @Autowired
    private IAbilityService abilityService;

    @GetMapping("/addPokemon")
    public String addPokemon(Model model) {

        var types = typeService.listTypes();
        var abilities = abilityService.listAbilities();
        Pokemon pokemon = new Pokemon();

        model.addAttribute("pokemon", pokemon);
        model.addAttribute("types", types);
        model.addAttribute("abilities", abilities);

        return "layout/addPokemon";
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

    @PostMapping("/save")
    public String save(
            @Valid Pokemon pokemon,
            @RequestParam(value = "nType") String nType,
            @RequestParam(value = "nAbility") String nAbility,
            Errors error) {

        if (error.hasErrors()) {
            return "index";
        }
        
        pokemon = typeAndAbilitySaves(pokemon, nType, nAbility);
        
        if (pokemon.getAbilities() == null || pokemon.getTypes() == null || pokemon.getAbilities().isEmpty() || pokemon.getTypes().isEmpty()) {
            return "index";
        }else{
            pokemonService.save(pokemon);
        }

        return "index";
    }

    @GetMapping("/addEvolution")
    public String addEvolution(Model model) {

        var types = typeService.listTypes();
        var abilities = abilityService.listAbilities();
        var pokemons = pokemonService.listPokemons();

        model.addAttribute("pokemon", new Pokemon());
        model.addAttribute("evolution", new Pokemon());
        model.addAttribute("pokemons", pokemons);
        model.addAttribute("types", types);
        model.addAttribute("abilities", abilities);

        return "layout/addEvolution";
    }

    @PostMapping("/saveEvolution")
    public String saveEvolution(
            @Valid Long id,
            @Valid Pokemon evolution,
            @RequestParam(value = "nType") String nType,
            @RequestParam(value = "nAbility") String nAbility,
            Errors error) {
        
        if (error.hasErrors()) {
            return "index";
        }
        
        Pokemon father = pokemonService.find(id);
  
        evolution = typeAndAbilitySaves(evolution, nType, nAbility);
        evolution = pokemonService.save(evolution);     
        
        father.addEvolution(evolution);

        if (father.getAbilities() == null || father.getTypes() == null || 
            father.getAbilities().isEmpty() || father.getTypes().isEmpty()) {
            return "index";
        }else{
           
            pokemonService.save(father);
        }
        return "index";
    }

    @GetMapping("/listPokemon")
    public String listPokemon(Model model) {

        var pokemons = pokemonService.listPokemons();

        model.addAttribute("pokemons", pokemons);

        return "layout/listPokemon";
    }
    
    @GetMapping("/delete")
    public String delete(Pokemon pokemon) {

        pokemonService.delete(pokemon);
        return "redirect:/listPokemon";
    }
}
