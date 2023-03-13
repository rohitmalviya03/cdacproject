package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Seller;
@Repository
public interface SellerDao extends CrudRepository<Seller, Long> {
	Optional<Seller> findByEmail(String email);
}
