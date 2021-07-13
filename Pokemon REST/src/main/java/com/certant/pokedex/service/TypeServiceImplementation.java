
package com.certant.pokedex.service;


import com.certant.pokedex.dao.ITypeDAO;
import com.certant.pokedex.domain.Type;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TypeServiceImplementation implements ITypeService{
    
    @Autowired
    private ITypeDAO typeDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Type> listTypes(){
        return (List<Type>) typeDAO.findAll();
    }

    @Override
    public void save(Type type) {
        typeDAO.save(type);
    }

    @Override
    public void delete(Type type) {
        typeDAO.delete(type);
    }

    @Override
    public Type find(Type type) {
        
        return typeDAO.findById(type.getIdType()).orElse(null);
    }
}
