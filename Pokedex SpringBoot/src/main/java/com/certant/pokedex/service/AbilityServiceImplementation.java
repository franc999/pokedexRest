/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.certant.pokedex.service;

import com.certant.pokedex.dao.IAbilityDAO;
import com.certant.pokedex.domain.Ability;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AbilityServiceImplementation implements IAbilityService{
    
    @Autowired
    private IAbilityDAO abilityDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Ability> listAbilities(){
        return (List<Ability>) abilityDAO.findAll();
    }

    @Override
    public Ability save(Ability ability) {
        return abilityDAO.save(ability);
    }

    @Override
    public void delete(Ability ability) {
        abilityDAO.delete(ability);
    }
    
    @Override
    public Ability find(Ability ability) {
        
        return abilityDAO.findById(ability.getIdAbility()).orElse(null);
    }
    /*
    @Override
    public Ability findByName(String ability) {
        return abilityDAO.findByName(ability);
    }*/
}
