package com.example.demoRest.api;

import com.example.demoRest.model.Customer;
import com.example.demoRest.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/customers")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void addCustomer(@Valid @NonNull @RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "{id}")
    public Customer getCustomerById(@PathVariable("id") UUID id) {
        return customerService.getCustomerById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCustomerById(@PathVariable("id") UUID id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping(path = "{id}")
    public void updateCustomerById(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Customer customerToUpdate) {
        customerService.updateCustomerById(id, customerToUpdate);
    }
}
