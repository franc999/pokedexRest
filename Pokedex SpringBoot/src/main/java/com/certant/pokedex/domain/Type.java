
package com.certant.pokedex.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data 
@Entity(name="type")
@Table(name="type")
public class Type implements Serializable{
    
    public static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idType;
    
    @NotEmpty(message="You must to select a type or write a new one")
    private String type;
}
