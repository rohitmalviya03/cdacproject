package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ProductService;

import jakarta.servlet.http.HttpSession;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.model.Product;

@RestController
@CrossOrigin
@RequestMapping("api/users")
public class HomeController {
	
	@Autowired
	CustomerService custService;
	@Autowired
	ProductService prodService;
	
	
	@PostMapping("/save")
	public String save(@RequestBody Customer cust)
	{
		custService.saveCustomer(cust);
		return "Customer Saved";
	}
	@GetMapping("/save")
	public List<Customer> getlist()
	{
		List<Customer> list=custService.fetchAll();
		return list;
	}
	@RequestMapping("/saveProduct")
    public String saveProduct(@RequestParam("file") MultipartFile file,
    		@RequestParam("name") String name,
    		@RequestParam("price") int price,
    		@RequestParam("description") String description,
    @RequestParam("category") String category,HttpSession session,Product product)
    {
		System.out.println("post product"+name);
    	//Long longValue = Long.valueOf(session.getAttribute("customerId").toString());
Long value=12323232342342L;
    	prodService.saveProduct(file, name, description, price,category,value);
    	System.out.println("datasaved");
    	return "data saved";
    	
    	
    }
	
	@GetMapping("/getProduct")
	public List<Product> getList(){
		
		List<Product> list = prodService.fetchAll();
		return list;
	}
	@PutMapping("/update")
	public String update(@RequestBody Customer cust)
	{
		custService.saveCustomer(cust);
		return "Customer Updated";
	}
	@DeleteMapping("/deleteuser/{id}")
	public String deletestudent(@PathVariable("id")int id)
	{
		custService.delete(id);
		return "Customer Deleted";
	}
}
