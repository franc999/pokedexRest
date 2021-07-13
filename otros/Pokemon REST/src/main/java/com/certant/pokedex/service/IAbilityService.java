
package com.certant.pokedex.service;

import com.certant.pokedex.domain.Ability;
import java.util.List;

public interface IAbilityService {
    
    /* methods to implements */
    public List<Ability> listAbilities();
    public void save(Ability ability);
    public void delete(Ability ability);
    public Ability find(Ability ability);
}