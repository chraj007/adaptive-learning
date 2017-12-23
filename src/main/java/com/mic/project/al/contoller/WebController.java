package com.mic.project.al.contoller;

import com.mic.project.al.dao.CustomerRepository;
import com.mic.project.al.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by veena on 23/12/17.
 */
@RestController
public class WebController {
    @Autowired
    CustomerRepository repository;

    @RequestMapping(method = RequestMethod.POST, path = "/save")
    public String process(@RequestBody Customer customer) {
        repository.save(customer);
        return "Done";
    }

    @RequestMapping("/findall")
    public String findAll() {
        String result="";
        for (Customer customer : repository.findAll()) {
            result += customer.toString() + "<br>";

        }
        return result;
    }



}
