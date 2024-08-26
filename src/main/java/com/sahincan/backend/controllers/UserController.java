package com.sahincan.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahincan.backend.entities.User;
import com.sahincan.backend.services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;



@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint: /users [GET]
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Endpoint: /users/{userId} [GET]
    @GetMapping("/{userId}")
    public User getOneUserById(@PathVariable Long userId) {
        return userService.getOneUserById(userId);
    }
    

    // Endpoint: /users [POST]
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        return userService.saveOneUser(newUser);
    }

    // Endpoint: /users/{userId} [PUT]
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId , @RequestBody User newUser) {
        return userService.updateOneUser(userId , newUser);
    }

    // Endpoint: /users/{userId} [DELETE]
    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId) {

        userService.deleteById(userId);
    }
}
