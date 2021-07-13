
package com.certant.pokedex.dao;

import com.certant.pokedex.domain.Type;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeDAO extends JpaRepository<Type, Long>{}
