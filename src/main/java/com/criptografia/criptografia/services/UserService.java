package com.criptografia.criptografia.services;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criptografia.criptografia.DTOs.UserDTO;
import com.criptografia.criptografia.domain.user.User;
import com.criptografia.criptografia.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public User findUserById(Long id) throws Exception{
        return this.repository.findUserById(id).orElseThrow(()-> new Exception("Usuario não encontrado"));
    }

    public void saveUser(User user){
        this.repository.save(user);
    }

    public User createUser(UserDTO data) throws Exception{
        User newUser = new User(data);
        newUser.setCreditCardToken(CriptoService.encode(newUser.getCreditCardToken()));
        newUser.setUserDocument(CriptoService.encode(newUser.getUserDocument()));
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }

}
