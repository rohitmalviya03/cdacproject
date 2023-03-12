package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CartItem;
import com.example.demo.model.Customer;

import jakarta.transaction.Transactional;

@Repository
public interface cartDao extends JpaRepository<CartItem, Long>,CrudRepository<CartItem, Long>{
//	  @Query("SELECT c FROM CartItem WHERE c.cust_id = :custId")
//	  CartItem findByIdWithItems1(@Param("custId") Long custId);
//	
//	 CartItem findByCart(long custId);
	 //@Query("select c from CartItem c join Customer  cu where c.customerid=:id:=cu.id")
//	@Query("select c FROM CartItem c inner join c.customer  where c.id=:custId")
//	List<CartItem> findAllByCustomer(@Param("custId") Long custId);
	
public List<CartItem>findByCustid(long custid);


public int deleteAllByCustid(long custid);

	
	
	
	
}
