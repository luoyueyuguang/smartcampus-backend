package com.sxu.smartcampus_java.service;

import com.sxu.smartcampus_java.entity.User;

import java.util.List;

public interface UserService {
    User findById(String userId);

    List<User> findAll();

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(String userId);
}

