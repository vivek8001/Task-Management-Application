package com.taskmanagement.service;

import com.taskmanagement.entity.User;
import com.taskmanagement.repository.UserRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements UserService{

    private UserRepositories userRepositories;

    @Override
    public List<User> getAllUsers() {
        return userRepositories.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepositories.findById(id).orElseThrow(()->new RuntimeException("User is not present"));
    }

    @Override
    public User createUser(User user) {
        return userRepositories.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User exists=getUserById(id);
        exists.setUsername(user.getUsername());
        exists.setPassword(user.getPassword());
        exists.setRoles(user.getRoles());
        exists.setFullName(user.getFullName());
        return userRepositories.save(exists);
    }

    @Override
    public void deleteUser(Long id) {
        userRepositories.deleteById(id);
    }
}
