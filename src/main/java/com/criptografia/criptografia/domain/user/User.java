package com.criptografia.criptografia.domain.user;

import com.criptografia.criptografia.DTOs.UserDTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")

public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userDocument;

    private String creditCardToken;

    @Column(name="ValueFrom")
    private long value;


    public User(UserDTO data){
        this.creditCardToken = data.creditCardToken();
        this.userDocument = data.userDocument();
        this.value = data.value();
    }
}
