package com.nogs.ongprojectbackend.controller;

import com.nogs.ongprojectbackend.model.dao.User;
import com.nogs.ongprojectbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService firebaseService;

    @GetMapping
    public User getUser(@RequestParam String id) throws InterruptedException, ExecutionException {
        return firebaseService.getUserDetails(id);
    }

    @GetMapping("/list")
    public List<User> getUsers() throws InterruptedException, ExecutionException {
        return firebaseService.getUserDetails();
    }

    @PostMapping
    public String createUser(@RequestBody User user) throws InterruptedException, ExecutionException {
        return firebaseService.saveUserDetails(user);
    }

    @PutMapping
    public String updateUser(@RequestBody User user) throws InterruptedException, ExecutionException {
        return firebaseService.updateUserDetails(user);
    }

    @DeleteMapping
    public String deleteUser(@RequestParam String id) {
        return firebaseService.deleteUser(id);
    }
}