package com.wipro.security.jwt.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.security.jwt.entity.User;
import com.wipro.security.jwt.entity.UserRequest;
import com.wipro.security.jwt.entity.UserResponse;
import com.wipro.security.jwt.service.IUserService;
import com.wipro.security.jwt.util.JWTUtil;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private IUserService userService;
    
    @Autowired
    private JWTUtil jwtUtil;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    // Sign Up and Return JWT
    @PostMapping("/saveUser")
    public ResponseEntity<UserResponse> saveUser(@RequestBody User user) {
        // Save user and get the generated ID
        Integer id = userService.saveUser(user);

        // Authenticate the newly registered user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        
        // Set authentication to the context (optional but useful in some cases)
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generate JWT Token for the newly registered user
        String token = jwtUtil.generateToken(user.getUsername());
        
        // Return the token with a success message
        return ResponseEntity.ok(new UserResponse(token, "User registered successfully with ID '" + id + "'"));
    }

    // User Login and JWT Generation
    @PostMapping("/loginUser")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest request) {
        // Validate username/password with DB (Stateless Authentication)
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        
        // Generate JWT token
        String token = jwtUtil.generateToken(request.getUsername());
        
        // Return the token with a success message
        return ResponseEntity.ok(new UserResponse(token, "Token generated successfully!"));
    }

    // Access Restricted Data After Login
    @PostMapping("/getData")
    public ResponseEntity<String> testAfterLogin(Principal p) {
        // Return a message after successful login
        return ResponseEntity.ok("You are accessing data after a valid login. You are: " + p.getName());
    }
}
