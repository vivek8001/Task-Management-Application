package com.taskmanagement.service;

import com.taskmanagement.entity.User;
import com.taskmanagement.repository.UserRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    UserRepositories userRepositories;

    @Override
    public List<User> getAllUsers() {
        return userRepositories.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepositories.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public User createUser(User user) {
        return userRepositories.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User exists=getUserById(id);
        exists.setFullName(user.getFullName());
        exists.setPassword(user.getPassword());
        exists.setRoles(user.getRoles());
        exists.setUsername(user.getUsername());
        return userRepositories.save(exists);
    }

    @Override
    public void deleteUser(Long id) {
        userRepositories.deleteById(id);
    }
}
