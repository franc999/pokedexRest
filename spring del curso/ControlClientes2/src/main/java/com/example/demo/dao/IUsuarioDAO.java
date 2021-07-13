
package com.example.demo.dao;

import com.example.demo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long>{
   
   Usuario findByUsername(String username);
}