package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SellerDao;
import com.example.demo.model.Customer;
import com.example.demo.model.Seller;
@Service
public class SellerImple implements SellerService{
	@Autowired
	SellerDao sellerDao;
	@Override
	public Seller saveSellerr(Seller seller) {
		// TODO Auto-generated method stub
	
		return sellerDao.save(seller);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int update(Customer student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Seller getSeller(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> fetchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Seller> findByEmail(String email) {
		// TODO Auto-generated method stub
		return sellerDao.findByEmail(email);
	}

	

}
