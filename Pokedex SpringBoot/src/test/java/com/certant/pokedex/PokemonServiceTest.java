package com.certant.pokedex;

import com.certant.pokedex.dao.IAbilityDAO;
import com.certant.pokedex.dao.IPokemonDAO;
import com.certant.pokedex.dao.ITypeDAO;
import com.certant.pokedex.domain.Ability;
import com.certant.pokedex.domain.Pokemon;
import com.certant.pokedex.domain.Type;
import com.certant.pokedex.service.PokemonServiceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PokemonServiceTest {

    @MockBean
    private IPokemonDAO pokemonMock;
    
    @MockBean
    private ITypeDAO typeMock;
    
    @MockBean
    private IAbilityDAO abilityMock;
    
    @InjectMocks
    private PokemonServiceImplementation pokemonServiceImp;
    
    @Test
    public void listPokemonsTest() {
        
        List<Pokemon>pokemons = new ArrayList();
        
        Pokemon pokemon = new Pokemon();
        Type type = new Type();
        Ability ability = new Ability();
        
        Pokemon pokemon1 = new Pokemon();
        Type type1 = new Type();
        Ability ability1 = new Ability();
        
        type.setType("Agua");
        ability.setAbility("Dispara");
        
        pokemon.setIdPokemon(1L);
        pokemon.setLevel(2);
        pokemon.setName("Pikachu");
        pokemon.addAbility(ability);
        pokemon.addType(type);
        
        type1.setType("Fuego");
        ability1.setAbility("Rayo");
        
        pokemon1.setIdPokemon(2L);
        pokemon1.setLevel(6);
        pokemon1.setName("Charmander");
        pokemon1.addAbility(ability1);
        pokemon1.addType(type1);
        
        pokemons.add(pokemon);
        pokemons.add(pokemon1);
        
        given(pokemonMock.findAll()).willReturn(pokemons);
        
        List<Pokemon> expected = pokemonServiceImp.listPokemons();
        
        assertEquals(expected, pokemons);
    }
    
    @Test
    void saveTest(){
        Pokemon pokemon = new Pokemon();
        
        Type type = new Type();
        type.setType("Agua");
        
        Ability ability = new Ability();
        ability.setAbility("Dispara");
        
        pokemon.setLevel(2);
        pokemon.setName("Pikachu");
        pokemon.addAbility(ability);
        pokemon.addType(type);
        
        given(pokemonMock.save(pokemon)).willAnswer
        (invocation -> invocation.getArgument(0));
        
        Pokemon savedPokemon = pokemonMock.save(pokemon);
        
        assertThat(savedPokemon).isNotNull();
        
        verify(pokemonMock).save(any(Pokemon.class));
    }
    
    @Test
    public void findPokemonTest(){
        
        Pokemon pokemon = new Pokemon();
        
        Type type = new Type();
        type.setType("Agua");
        
        Ability ability = new Ability();
        ability.setAbility("Dispara");
        
        pokemon.setIdPokemon(1L);
        pokemon.setLevel(2);
        pokemon.setName("Pikachu");
        pokemon.addAbility(ability);
        pokemon.addType(type);
        
        given(pokemonMock.findById(pokemon.getIdPokemon()))
                .willReturn(Optional.of(pokemon));
        
        /*assertThrows(PokemonAddException.class,() -> {
            pokemonServiceImp.save(pokemon);
        })*/
        
        verify(pokemonMock, never()).save(any(Pokemon.class));
    }
    
  
    @Test
    public void deleteTest(){
        
        Pokemon pokemon = new Pokemon();
        
        Type type = new Type();
        type.setType("Agua");
        
        Ability ability = new Ability();
        ability.setAbility("Dispara");
        
        pokemon.setIdPokemon(1L);
        pokemon.setLevel(2);
        pokemon.setName("Pikachu");
        pokemon.addAbility(ability);
        pokemon.addType(type);
        
        pokemonServiceImp.deleteById(pokemon.getIdPokemon());
        pokemonServiceImp.deleteById(pokemon.getIdPokemon());
        
        verify(pokemonMock, times(2)).deleteById(pokemon.getIdPokemon());
    }
    
    /*@Test
    void typeAndAbilitySavesTest(){
        
        //(Pokemon pokemon, String nType, String nAbility
        Pokemon pokemon = new Pokemon();
        pokemon.setIdPokemon(1L);
        pokemon.setLevel(2);
        pokemon.setName("Pikachu");
        
        String type = "Type";
        String ability = "Ability";
        "this . typeService in method is null"
        pokemon = pokemonServiceImp.typeAndAbilitySaves(pokemon, type, ability);
        
        assertEquals(type, pokemon.getTypes().get(0));
    }*/
}