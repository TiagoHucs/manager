package com.hucs.manager.core.user;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<String, String> users = new HashMap<>();

    // Autenticação de usuário (login)
    public boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    // Registro de usuário (sign up)
    public boolean register(User user) {
        if (users.containsKey(user.getUsername())) {
            return false; // Usuário já existe
        }
        users.put(user.getUsername(), user.getPassword());
        return true;
    }
}
