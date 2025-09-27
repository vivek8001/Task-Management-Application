package com.taskmanagement.controller;

import com.taskmanagement.entity.User;
import com.taskmanagement.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @GetMapping("{/id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping
    public User insertUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("{/id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping("{/id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
