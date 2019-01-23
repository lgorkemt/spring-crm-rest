package com.turan.springdemo.rest;

import com.turan.springdemo.entity.Customer;
import com.turan.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    // autowire the CustomerService
    @Autowired
    private CustomerService customerService;

    // add mapping for GET/ customers
    @GetMapping("/customers")
    public List<Customer> getCustomers(){

        return customerService.getCustomers();

    }

    // add mapping for GET/ customers
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){

        Customer customer =  customerService.getCustomer(customerId);
        if(customer == null){
            throw new CustomerNotFoundException("Customer with the following id does not exist in the database. id : " + customerId);
        }
        return customer;
    }

    // add mapping for POST/ customers - add a new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){

        // set the id of the customer id to 0
        // this will force to make an insert instead of update
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }

    // add mapping for PUT/ customers - update a new customer
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){

        // set the id of the customer id to 0
        // this will force to make an insert instead of update
        customerService.saveCustomer(customer);
        return customer;
    }

    // add mapping for PUT/ customers - update a new customer
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){

        Customer customer = customerService.getCustomer(customerId);
        if(customer == null){
            throw new CustomerNotFoundException("Customer with the following id does not exist in the database. id : " + customerId);
        }
        // set the id of the customer id to 0
        // this will force to make an insert instead of update
        customerService.deleteCustomer(customerId);
        return "The deleted customer is : " + customerId;

    }
}
