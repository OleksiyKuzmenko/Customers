package com.example.demoRest.service;

import com.example.demoRest.dao.CustomerDAO;
import com.example.demoRest.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerService(@Qualifier("customerDAO") CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void addCustomer(Customer customer) {
        customer.setId(UUID.randomUUID());
        customer.setIsActive(true);
        customerDAO.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.findAllByIsActive(true);
    }

    public Optional<Customer> getCustomerById(UUID id) {
        return customerDAO.findByIdAndIsActive(id, true);
    }

    public void deleteCustomer(UUID id) {
        Optional<Customer> customerOptional = customerDAO.findById(id);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customer.setIsActive(false);
            customerDAO.save(customer);
        }
    }

    public void updateCustomerById(UUID id, Customer newCustomer) {
        Optional<Customer> existingCustomer = customerDAO.findById(id);
        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            customer.setFullName(newCustomer.getFullName());
            customer.setEmail(newCustomer.getEmail());
            customer.setPhone(newCustomer.getPhone());
            customer.setIsActive(newCustomer.getIsActive());
            customerDAO.save(customer);
        }
    }
}
