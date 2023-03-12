package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.cartDao;
import com.example.demo.model.CartItem;
import com.example.demo.model.Customer;


@Service
public class CartService {
	
	
	
	@Autowired
	CustomerService cserv;
	
	@Autowired
	cartDao cartdao;
	 public void addItemToCart(Long cartId,CartItem cartItem) {
		 System.out.println("Cartrepo"+cartId);
		 Customer c=cserv.getCustomer(cartId);
		 //cartItem.setCustomer(c);
			/*
			 * Cart cartData = new Cart(); cartData.setCartid(cartId);
			 * cartRepository.save(cartData);
			 */
		 //Cart cart = cartRepository.findById(cartId).orElseThrow();
	        
			/*
			 * CartItem cartobj = new CartItem(); cartobj.setName(cartItem.getName());
			 * cartobj.setPrice(cartItem.getPrice());
			 * cartobj.setQuantity(cartItem.getQuantity()); cartobj.setCart(cart);
			 * cartobj.setCust_id(cartItem.getCust_id()); cart.getItems().add(cartobj);
			 */
		 cartdao.save(cartItem);
	       
	    }
	 
	 public Optional<CartItem> data(long custid) {
		 
		 return cartdao.findById(custid);
	 }
//	 
// public CartItem data2(long id) {
//		 
//		 
//		return cartdao.findByIdWithItems(id);
//	 }
	 
	}

