
package com.certant.pokedex.service;

import com.certant.pokedex.domain.Type;
import java.util.List;

public interface ITypeService {
    
    /* methods to implements */
    public List<Type> listTypes();
    public void save(Type type);
    public void delete(Type type);
    public Type find(Type type);
}