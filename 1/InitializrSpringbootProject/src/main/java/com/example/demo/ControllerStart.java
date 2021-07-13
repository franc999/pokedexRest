
package com.example.demo;

import com.example.demo.domain.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControllerStart {
    
    @Value("${index.saludo}")
    private String saludo;
    
    
    @GetMapping("/")
    public String start(Model model){
        
        var persona = new Persona();
        persona.setNombre("Jorge");
        persona.setApellido("Rodriguez");
        persona.setEmail("jorge@gmail.com");
        persona.setTelefono("2255465238");
        
        var persona2 = new Persona();
        persona2.setNombre("Karlos");
        persona2.setApellido("Gomez");
        persona2.setEmail("Shet@gmail.com");
        persona2.setTelefono("558461");
        
        //var List<Persona> personas = new ArrayList();
        //personas.add(persona);
        //personas.add(persona2);
        
        var personas = Arrays.asList(persona, persona2);
        
        
        var mensaje = "Hola mundo con thymeleaf";
        log.info("EJECUTANDO controlador MVC");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        //model.addAttribute("persona", persona);
        
        model.addAttribute("personas", personas);
        return "index";
    }
}
