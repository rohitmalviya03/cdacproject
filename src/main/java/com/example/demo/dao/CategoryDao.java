package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Category;

public interface CategoryDao extends JpaRepository<Category, Long>, CrudRepository<Category, Long>{
	 
}
