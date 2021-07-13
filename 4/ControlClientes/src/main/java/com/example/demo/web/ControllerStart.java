
package com.example.demo.web;

import com.example.demo.dao.IPersonaDAO;
import com.example.demo.service.IPersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
