package com.sxu.smartcampus_java.service.impl;

import com.sxu.smartcampus_java.entity.User;
import com.sxu.smartcampus_java.mapper.UserMapper;
import com.sxu.smartcampus_java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(String userId) {
        return userMapper.findById(userId);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void createUser(User user) {
        if (userMapper.findById(user.getUserId()) != null) {
            throw new RuntimeException("User already exists with ID: " + user.getUserId());
        }
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        if (userMapper.findById(user.getUserId()) == null) {
            throw new RuntimeException("User not found with ID: " + user.getUserId());
        }
        userMapper.update(user);
    }

    @Override
    public void deleteUser(String userId) {
        if (userMapper.findById(userId) == null) {
            throw new RuntimeException("User not found with ID: " + userId);
        }
        userMapper.delete(userId);
    }
}
