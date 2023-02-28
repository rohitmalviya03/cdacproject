package com.example.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Product;
public interface ProductService {
	public Product  saveProduct(MultipartFile file, String name,String description
			,int price,String category,long seller_id) ;
	public void delete(int id);
	public int update(Product prod);
	public Product getProducts(long id);
	public List<Product> fetchAll();
	public List<Product> findByPrice(int price);
public int getCount();
	public List<Product> findByCategory(String category);
}
