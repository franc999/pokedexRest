package com.certant.pokedex.service;
/*
import com.certant.pokedex.dao.IUserDAO;
import com.certant.pokedex.domain.Rol;
import com.certant.pokedex.domain.User;
import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userDetailsService")
@Slf4j
public class IUserService implements UserDetailsService {
        
    @Autowired
    private IUserDAO userDAO;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        // nos da la lista de roles, con JPA detecta que tipos hay/
        var roles = new ArrayList<GrantedAuthority>();

        for (Rol rol : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getName()));
        }
        // user de spring //
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
    }
}*/