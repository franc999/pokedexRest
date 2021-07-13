
package com.certant.pokedex.web;

import com.certant.pokedex.domain.UserClass;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class StartController {
    
    @GetMapping("/")
    public String home(/*@AuthenticationPrincipal*/ UserClass user){
        
        return "index";
    }
}