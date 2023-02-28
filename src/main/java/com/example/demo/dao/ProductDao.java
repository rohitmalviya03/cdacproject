package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;
@Repository
public interface ProductDao  extends  JpaRepository<Product, Long>, CrudRepository<Product, Long>{
public List<Product> findByPrice(int price);
public List<Product> findByCategory(String category);
}
