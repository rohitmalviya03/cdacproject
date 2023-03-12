package com.example.demo.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import  com.example.demo.model.Customer;
@Repository
public interface CustomerDao  extends JpaRepository<Customer, Long>, CrudRepository<Customer, Long>{
	 Optional<Customer> findByEmail(String email);
	 
	 
	 @Query("select c from Customer c where c.id=:i")
	 public  Customer getCustomerbycid(@Param ("i")long id);
}
