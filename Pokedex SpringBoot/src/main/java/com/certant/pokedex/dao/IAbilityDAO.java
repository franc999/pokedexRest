
package com.certant.pokedex.dao;

import com.certant.pokedex.domain.Ability;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAbilityDAO extends JpaRepository<Ability, Long>{}
