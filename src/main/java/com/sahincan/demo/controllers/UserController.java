package com.sahincan.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.sahincan.demo.entities.User;
import com.sahincan.demo.repositories.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Endpoint: /users [GET]
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Endpoint: /users/{userId} [GET]
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId) {
        // TODO: custom exception ekle

        
        return userRepository.findById(userId).orElse(null);
    }
    

    // Endpoint: /users [POST]
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        var createdUser = userRepository.save(newUser);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Endpoint: /users/{userId} [PUT]
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId , @RequestBody User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        } else {
            
            // TODO: exception yaz
            return null;
        }
    }

    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId) {

        userRepository.deleteById(userId);
    }
}
