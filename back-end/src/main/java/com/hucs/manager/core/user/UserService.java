package com.hucs.manager.core.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Autenticação de usuário (login)
    public boolean authenticate(String username, String password) {
        User user = findByUsername(username);
        if(user == null){
            return false;
        }
        return user.getUsername().equals(username) && user.getPassword().equals(password);
    }

    // Registro de usuário (sign up)
    public boolean register(User user) {
        if (findByUsername(user.getUsername()) != null) {
            return false; // Usuário já existe
        }
        userRepository.save(user);
        return true;
    }

    private User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
