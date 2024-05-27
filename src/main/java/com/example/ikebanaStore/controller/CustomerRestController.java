package com.example.ikebanaStore.controller;

import com.example.ikebanaStore.service.CustomerService;
import com.example.ikebanaStore.model.Customer;
import com.example.ikebanaStore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping ("/api/v1/customer")
public class CustomerRestController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerService customerService;

    //CRUD GET
    public Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    //CRUD CREATE
    @PostMapping(path="create", consumes = "application/JSON")
    public Customer createCustomer(@RequestBody Customer customer){
        Customer customerCreated = customerRepository.save(customer);
        return customerCreated;
    }

    //CRUD Update
    @PutMapping ("/update/{id}")
    public Customer updateCustomer (@PathVariable String id, @RequestBody Customer customer) {
        Optional<Customer> customerFound = customerRepository.findById(id);

        if (customerFound.isPresent()) {
            Customer customerToUpdate = customerFound.get();
            Customer customerUpdated = customerRepository.save(customerToUpdate);
            return customerUpdated;
        } else
            return null;
    }

    //CRUD DELETE
    public String deleteCustomer(@RequestParam String id){
        Optional<Customer> customerFound= customerRepository.findById(id);
        long countBefore = customerRepository.count();
        if(customerFound.isPresent()){
            customerRepository.deleteById(id);
            long countAfter = customerRepository.count();
            String response = "customer deleted: " + id +" count: " + countBefore +"/" + countAfter;
            return response;
        } else return "id: " +id +"not found " +"count: " + countBefore;
    }
    public String populateCustomerDB(){
        customerService.populate();
        return "ok";
    }
}
