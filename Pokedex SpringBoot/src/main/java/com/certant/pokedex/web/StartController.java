
package com.certant.pokedex.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class StartController {
    
    @GetMapping("/")
    public String home(){
        
        return "index";
    }

}