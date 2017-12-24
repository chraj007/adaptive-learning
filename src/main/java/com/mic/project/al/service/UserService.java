package com.mic.project.al.service;


import com.mic.project.al.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
