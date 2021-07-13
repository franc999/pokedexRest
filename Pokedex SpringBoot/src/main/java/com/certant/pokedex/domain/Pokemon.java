
package com.certant.pokedex.domain;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data 
@Entity
@Table(name="pokemon")
public class Pokemon implements Serializable{
    
    public static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPokemon;
    
    @NotBlank(message="You not enter a Pokemon's name")
    private String name;
    
    @NotNull(message="Level is null")
    private int level;
    
    @ManyToMany
    @JoinTable(name="pok_ab"
              ,joinColumns=@JoinColumn(name="fk_pokemon")
              ,inverseJoinColumns=@JoinColumn(name="fk_ability")
              )
    private List<Ability> abilities;
    
    @ManyToMany
    @JoinTable(name="pok_evo"
              ,joinColumns=@JoinColumn(name="fk_pokemon")
              ,inverseJoinColumns=@JoinColumn(name="fk_evolution")
              )
    private List<Pokemon> evolutions;
    
    @ManyToMany
    @JoinTable(name="pok_type"
              ,joinColumns=@JoinColumn(name="fk_pokemon")
              ,inverseJoinColumns=@JoinColumn(name="fk_type")
              )
    private List<Type> types;
    
    public void addType(Type type){
        if(this.types == null || this.types.isEmpty()){
            this.types = new ArrayList<>();
        }

        this.types.add(type);
    }
    
    public void addAbility(Ability ability){
        if(this.abilities == null || this.abilities.isEmpty()){
            this.abilities = new ArrayList<>();
        }
        
        this.abilities.add(ability);
    }
    
    public void addEvolution(Pokemon evolution){
        if(this.evolutions == null || this.evolutions.isEmpty()){
            this.evolutions = new ArrayList<>();
        }
        
        this.evolutions.add(evolution);
    }
}
