
package com.example.demo.service;

import com.example.demo.dao.IPersonaDAO;
import com.example.demo.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service /*implementamos la interface persona service */
public class PersonaServiceImplementation implements IPersonaService {
    
    @Autowired /* implementamos interface personaDAO */
    private IPersonaDAO personaDAO;
    
    @Override
    @Transactional(readOnly = true)  /* que hace una vez que lee, transaccion dependiendo elcaso*/
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDAO.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDAO.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDAO.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encuentra(Persona persona) {
        /*si no encuentra el buscado da null */
        return personaDAO.findById(persona.getIdPersona()).orElse(null);
    }
    
}
