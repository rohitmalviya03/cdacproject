package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CartItem;
import com.example.demo.model.orders;

@Repository
public interface orderDao  extends JpaRepository<orders, Long>, CrudRepository<orders, Long>{
	public List<orders>findByCustid(long custid);
	

}
