package com.hucs.manager.web.controllers.auth;

import com.hucs.manager.web.controllers.auth.vo.UserAuth;
import com.hucs.manager.web.jwt.JwtUtil;
import com.hucs.manager.core.user.User;
import com.hucs.manager.core.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {
    private static final String USER_ALREADY_EXISTS = "Nome de usuário já cadastrado";
    private static final String PASS_OR_USERNAME_INVALID = "Nome de usuário ou senha inválidos";
    private static final String SUCCESS_REGISTER = "Usuário cadastrado com sucesso";


    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserAuth user) {
        Map<String, String> response = new HashMap<>();
        boolean isAuthenticated = userService.authenticate(user.getUsername(), user.getPassword());
        if (isAuthenticated) {
            String token = JwtUtil.generateToken(user.getUsername());
            response.put("token", token);  // Devolve o token em formato JSON
            return ResponseEntity.ok(response);
        } else {
            response.put("error", PASS_OR_USERNAME_INVALID);  // Devolve o erro como JSON
            return ResponseEntity.status(401).body(response);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody User user) {
        Map<String, String> response = new HashMap<>();
        boolean isRegistered = userService.register(user);
        if (isRegistered) {
            response.put("msg", SUCCESS_REGISTER);
            return ResponseEntity.ok(response);
        } else {
            response.put("error", USER_ALREADY_EXISTS);  // Devolve o erro como JSON
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}
