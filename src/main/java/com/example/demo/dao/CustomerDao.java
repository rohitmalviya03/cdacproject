package com.example.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import  com.example.demo.model.Customer;
@Repository
public interface CustomerDao  extends JpaRepository<Customer, Long>, CrudRepository<Customer, Long>{
	 Customer findByEmail(String email);
}
