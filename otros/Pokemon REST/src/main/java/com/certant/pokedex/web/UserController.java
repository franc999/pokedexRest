
package com.certant.pokedex.web;


import com.certant.pokedex.dao.IUserDAO;
import com.certant.pokedex.domain.UserClass;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class UserController {
    
    @Autowired
    private IUserDAO userDAO;
    
    @GetMapping("/register")
    public String register(UserClass user){
        
        return "layout/register";
    }
    
    @PostMapping("/saveUser")
    public String saveUser(@Valid UserClass user, Errors error){
        
        if(error.hasErrors()){
            
            return "index";
        }
        
        userDAO.save(user);
        return "index";
    }
}
