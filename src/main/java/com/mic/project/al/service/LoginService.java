package com.mic.project.al.service;

import com.mic.project.al.dao.UserRepository;
import com.mic.project.al.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by veena on 23/12/17.
 */
@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    public void register(User user) {

        userRepository.save(user);

    }
}
