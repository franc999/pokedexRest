
package com.example.demo.service;

import com.example.demo.domain.Persona;
import java.util.List;

public interface IPersonaService {
        
    public List<Persona> listarPersonas();
    
    public void guardar(Persona persona);
    
    public void eliminar(Persona persona);
    
    public Persona encuentra(Persona persona);
}
