package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer;

@Service
public class CustomerServiceImp implements CustomerService {
@Autowired
CustomerDao custDao;



	@Override
	public Customer saveCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return custDao.save(cust);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		custDao.deleteById(id);
		
	}

	@Override
	public int update(Customer student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Customer getCustomer(long id) {
		//Optional<Customer> opt=custDao.findById(id);
		
	
		//	return opt.get();
		return custDao.getCustomerbycid(id);
	}

	@Override
	public List<Customer> fetchAll() {
		// TODO Auto-generated method stub
		return (List<Customer>) custDao.findAll();
	}

	@Override
	public Optional<Customer> findByEmail(String email) {
		// TODO Auto-generated method stub
		return custDao.findByEmail(email);
	}
	

}
