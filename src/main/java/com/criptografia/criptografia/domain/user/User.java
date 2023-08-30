package com.criptografia.criptografia.domain.user;

import com.criptografia.DTOs.UserDTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userDocument;

    private String creditCardToken;

    private long value;


    public User(UserDTO data){
        this.creditCardToken = data.creditCardToken();
        this.userDocument = data.userDocument();
        this.value = data.value();
    }
}
