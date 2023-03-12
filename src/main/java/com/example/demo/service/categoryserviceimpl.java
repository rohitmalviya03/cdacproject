package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CategoryDao;
import com.example.demo.model.Category;
import com.example.demo.model.Customer;
@Service
public class categoryserviceimpl implements categoryServie{

	
	@Autowired
	CategoryDao catDao;

	@Override
	public Category savCategory(Category cat) {
		// TODO Auto-generated method stub
		return catDao.save(cat);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public List<Category> fetchAll() {
		// TODO Auto-generated method stub
		return  catDao.findAll();
	}
	

}
