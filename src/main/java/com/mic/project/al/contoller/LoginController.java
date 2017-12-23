package com.mic.project.al.contoller;

import com.mic.project.al.dao.CustomerRepository;
import com.mic.project.al.dao.UserRepository;
import com.mic.project.al.model.Customer;
import com.mic.project.al.model.User;
import com.mic.project.al.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by veena on 23/12/17.
 */
@Controller

public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public String register(@RequestBody User user) {
        loginService.register(user);
        return "Done";
    }

    @RequestMapping("/")
    public String loadIndexPage(Map<String, Object> model) {
        model.put("message", "Hello");
        return "index";
    }

}
