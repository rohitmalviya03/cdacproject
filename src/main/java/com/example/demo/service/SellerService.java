package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Customer;
import com.example.demo.model.Seller;

public interface SellerService {
	public Seller saveSellerr(Seller seller);
	public void delete(int id);
	public int update(Customer student);
	public Seller getSeller(long id);
	public List<Seller> fetchAll();
	public Optional<Seller> findByEmail(String email);
}
