package com.criptografia.criptografia.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criptografia.DTOs.UserDTO;
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

    public User createUser(UserDTO data){
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }

}
