package com.certant.pokedex;

import com.certant.pokedex.dao.IPokemonDAO;
import com.certant.pokedex.domain.Ability;
import com.certant.pokedex.domain.Pokemon;
import com.certant.pokedex.domain.Type;
import com.certant.pokedex.service.IPokemonService;
import com.certant.pokedex.service.PokemonServiceImplementation;
import com.certant.pokedex.web.PokemonController;
import com.certant.pokedex.web.PokemonRestController;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RunWith(SpringRunner.class)
@WebMvcTest(PokemonController.class)
@ExtendWith(MockitoExtension.class)
public class PokemonControllerTest {
    
    /*@Mock
    private IPokemonDAO pokemonDAO;
    
    @Mock
    private IPokemonService service;
    
    @InjectMocks
    private PokemonRestController pokemonController;

    @Test
    void testAddPokemon(){
        
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        //when(pokemonDAO.save(any(Pokemon.class))).thenReturn(Pokemon);
        
        Pokemon pokemon = new Pokemon();

        pokemon.setIdPokemon(1L);
        pokemon.setLevel(2);
        pokemon.setName("Pikachu");
        
        ResponseEntity<?> responseEntity = pokemonController.create(pokemon, "Agua", "Dispara");
        
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }*/
}
