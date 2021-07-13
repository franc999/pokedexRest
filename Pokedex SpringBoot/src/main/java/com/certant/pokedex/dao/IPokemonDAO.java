
package com.certant.pokedex.dao;

import com.certant.pokedex.domain.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPokemonDAO extends JpaRepository<Pokemon, Long>{
}
