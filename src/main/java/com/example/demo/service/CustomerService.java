package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Customer;
public interface CustomerService {
	
	public Customer saveCustomer(Customer cust);
	public void delete(long id);
	public int update(Customer student);
	public Customer getCustomer(long id);
	public List<Customer> fetchAll();
	public Optional<Customer> findByEmail(String email);
}
