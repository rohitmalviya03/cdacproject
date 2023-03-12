package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
public interface ProductService {
	public Product  saveProduct(MultipartFile file, String name,String description
			,int price,Category category,long seller_id) ;
	public void delete(int id);
	public int update(Product prod);
	public Optional<Product> getProducts(long id);
	public List<Product> fetchAll();
	public List<Product> findByPrice(int price);
	public List<Product> findProductById(long id);
    public int getCount();
	public List<Product> findByCategory(String category);
	
}
