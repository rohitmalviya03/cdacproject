package com.example.demo.service;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	ProductDao productDao;
	
	@Override
	public Product saveProduct(MultipartFile file, String name,String description
			,int price,String category,long seller_id) {
		// TODO Auto-generated method stub
		

			Product p = new Product();
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			if(fileName.contains(".."))
			{
				System.out.println("not a a valid file");
			}
			try {
				System.out.println("try blok for img");
				p.setImage(file.getBytes());
				System.out.println("set image suucess");
			} catch (IOException e) {
				System.out.println("catch block");
				e.printStackTrace();
			}
			p.setDescription(description);
			System.out.print(name+" "+price+"  "+description);
	        p.setName(name);
	        p.setPrice(price);
	        p.setCategory(category);
	        p.setSeller_id(seller_id);
	        return productDao.save(p);}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int update(Product prod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product getProducts(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> fetchAll() {
		// TODO Auto-generated method stub
		return (List<Product>) productDao.findAll();
	}

	@Override
	public List<Product> findByPrice(int price) {
		// TODO Auto-generated method stub
		return (List<Product>) productDao.findByPrice(price);
	}

	@Override
	public List<Product> findByCategory(String category) {
		// TODO Auto-generated method stub
		return productDao.findByCategory(category);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		List<Product> prod =productDao.findAll();
		int count=prod.size();
		return count;
	}

	

}
