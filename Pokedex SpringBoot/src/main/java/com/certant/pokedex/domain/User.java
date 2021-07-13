
package com.certant.pokedex.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data 
@Entity
@Table(name="user", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User implements Serializable{
    
    public static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    
    @NotBlank
    private String username;
    
    @NotBlank
    private String password;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_rol",
            joinColumns = @JoinColumn(name = "fk_user"),
            inverseJoinColumns = @JoinColumn(name = "fk_rol")
            )
    private Set<Rol> roles = new HashSet<>();
    
    private boolean enabled;
}