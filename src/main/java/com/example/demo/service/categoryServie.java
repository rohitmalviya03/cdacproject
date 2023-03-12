package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category;
import com.example.demo.model.Customer;

public interface categoryServie {
	public Category savCategory(Category cat);
	public void delete(long id);
	

	public List<Category> fetchAll();
}
