package com.taskmanagement.service;

import com.taskmanagement.entity.User;

import java.util.List;

public interface ProjectService {

    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id,User user);
    void deleteUser(Long id);
}
