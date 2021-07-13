
package com.example.demo.web;

import com.example.demo.dao.IPersonaDAO;
import com.example.demo.domain.Persona;
import com.example.demo.service.IPersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControllerStart {
    
    @Autowired
    private IPersonaService personaService;
    
    @GetMapping("/")
    public String start(Model model){
        
        var personas = personaService.listarPersonas();
        log.info("EJECUTANDO controlador MVC");
        
        model.addAttribute("personas", personas);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar (Persona persona){
        
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar (Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    /* lo busca automaticamente por id si lo busca e inicializa erl objeto */
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encuentra(persona);
        model.addAttribute("persona", persona);
        return"modificar";
    }
    
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/eliminar")
    public String eliminarOtro(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}