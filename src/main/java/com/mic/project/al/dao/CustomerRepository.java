package com.mic.project.al.dao;

import com.mic.project.al.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by veena on 23/12/17.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);

}
