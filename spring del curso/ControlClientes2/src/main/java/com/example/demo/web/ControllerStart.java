
package com.example.demo.web;

import com.example.demo.dao.IPersonaDAO;
import com.example.demo.domain.Persona;
import com.example.demo.service.IPersonaService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControllerStart {
    
    @Autowired
    private IPersonaService personaService;
    
    @GetMapping("/")
    public String start(Model model, @AuthenticationPrincipal User user){
        
        var personas = personaService.listarPersonas();
        log.info("EJECUTANDO controlador MVC");
        
        model.addAttribute("personas", personas);
        
        var saldoTotal = 0D;
        for(var p: personas){
            saldoTotal += p.getSaldo();
        }
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());

        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar (Persona persona){
        
        return "modificar";
    }
    
    @PostMapping("/guardar") /** le pàsamos valid, y error para ver si tiene errores */
    public String guardar (@Valid Persona persona, Errors error){
        if(error.hasErrors()){
            return "modificar";
        }
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