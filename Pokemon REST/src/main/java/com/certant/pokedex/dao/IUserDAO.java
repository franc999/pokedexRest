
package com.certant.pokedex.dao;

import com.certant.pokedex.domain.UserClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDAO extends JpaRepository<UserClass, Long> {
    
    UserClass findByUsername(String username);
}
