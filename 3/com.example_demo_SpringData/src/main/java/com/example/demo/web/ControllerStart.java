
package com.example.demo.web;

import com.example.demo.dao.IPersonaDAO;
import com.example.demo.domain.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControllerStart {
    
    @Autowired
    private IPersonaDAO personaDAO;
    
    @GetMapping("/")
    public String start(Model model){
        
        var personas = personaDAO.findAll();
        log.info("EJECUTANDO controlador MVC");
        
        model.addAttribute("personas", personas);
        return "index";
    }
}
