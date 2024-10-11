package com.wipro.security.jwt.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.security.jwt.entity.User;
import com.wipro.security.jwt.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

    @Autowired
    private UserRepository userRepo; 
    
    @Autowired
    private BCryptPasswordEncoder bCryptEncoder;

    @Override
    public Integer saveUser(User user) {
        // Encode password before saving to DB
        user.setPassword(bCryptEncoder.encode(user.getPassword()));
        return userRepo.save(user).getId();
    }

    // Find user by username
    @Override
    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> opt = userRepo.findByUsername(username);
        
        if (opt.isEmpty()) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }
        
        User user = opt.get(); // retrieving user from DB
        Set<String> roles = user.getRoles();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (String role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }

        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                grantedAuthorities
        );
    }
}
