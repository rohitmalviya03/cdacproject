package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dao.cartDao;
import com.example.demo.model.CartItem;
import com.example.demo.model.Category;
import com.example.demo.model.Customer;
import com.example.demo.service.AuthResponse;
import com.example.demo.service.CartService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ProductService;
import com.example.demo.service.SellerService;
import com.example.demo.service.categoryServie;
import com.example.demo.service.orderService;

import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.example.demo.model.Seller;
import com.example.demo.model.orders;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/users")
public class HomeController {
	@Autowired
	SellerService sellerService;
	@Autowired
	CustomerService custService;
	@Autowired
	ProductService prodService;
	@Autowired
	orderService orderservice;
	@Autowired
	cartDao cartdao;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	categoryServie catservice;
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
	@PostMapping("/saveproduct")
    public String saveProduct(@RequestParam("file") MultipartFile file,
    		@RequestParam("name") String name,
    		@RequestParam("price") int price,
    		@RequestParam("description") String description,
    @RequestParam("category_id") Category category,HttpSession session,Product product)
    {
		System.out.println("post product"+category);
    	//Long longValue = Long.valueOf(session.getAttribute("customerId").toString());
Long value=12323232342342L;
    	prodService.saveProduct(file, name, description, price,category,value);
    	System.out.println("datasaved");
    	return "data saved";
    	
    	
    }
	
	@GetMapping("/getProduct")
	public List<Product> getList(){
		//Product prod =new Product();
		List<Product> list = prodService.fetchAll();
		//System.out.println("dd"+prod.getPrice());
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
	
	//login api
	@GetMapping("getsession")
	public String getsession(HttpSession session) {
		String data= (String) session.getAttribute("useremail");
		System.out.println(session.getAttribute("useremail"));
		return data;
	}
//	@PostMapping("/userlogin")
//	public Customer getuser(@RequestBody Customer cust,HttpSession session)
//	{
//		
//		String pwd;	
//		String err;       
//		System.out.println(cust.getPassword());
//		Customer existingUser = custService.findByEmail(cust.getEmail());
//	        if (existingUser != null && existingUser.getPassword().equals(cust.getPassword())) {
//	            return existingUser;
//	        } else {
//	            return existingUser;
//	        }}
//	
	
	  @PostMapping("/authenticate")
	    public ResponseEntity<AuthResponse> login( @RequestBody Customer cust) {
		  Optional<Customer> existingUser = custService.findByEmail(cust.getEmail());
		  
		  Customer user=existingUser.get();
	        if (existingUser != null && user.getPassword().equals(cust.getPassword())) {
	        	return ResponseEntity.ok(new AuthResponse(user.getId(), user.getFirstName()));
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	        }
		
	
	  }
	//cart function api
	
	@PostMapping("/usercart")
	public String loadCart(HttpSession session) {
	   String data= (String) session.getAttribute("useremail");
   	   System.out.println("welcome "+data+" to your cart");
   	 List<Category> catlist =catservice.fetchAll();
   	 
   	     System.out.println("rohh"+catlist);
		
		return "car loaded";
	}
	@GetMapping("/getcategory")
	public List<Category> getCat() {
		List<Category> catlist=catservice.fetchAll();
		 System.out.println(catlist);
		 return (List<Category>) catlist;
		
	}
	
	@GetMapping("/getproductbyid/{id}")
	public Optional<Product> getproductbyid(@PathVariable("id") long id){
return prodService.getProducts(id);
}
//cart
	
	
	 @PostMapping("cart/{cartId}/items/")
	    public long addItemToCart( @PathVariable Long cartId,@RequestBody CartItem cartItems) {
//	     System.out.println("asd"+cartItems.getCust_id());   
		 cartService.addItemToCart(cartId,cartItems);
	        return 151;
	    }
	 
	 @GetMapping("getcart/{custid}")
	    public List<CartItem> getCartItems(@PathVariable Long custid) {
//	     Cart cart = new Cart();
//	     cart.setCartid(cartId);
	        return cartdao.findByCustid(custid);
	 }
	 @DeleteMapping("/deletecart/{cartitemid}/{custid}")
	    public String cartclear(@PathVariable Long cartitemid,@PathVariable long custid) {
//	     Cart cart = new Cart();
//	     cart.setCartid(cartId);
		 cartdao.deleteById(cartitemid);
	        return "done";
	 }
	 
	 @Transactional
	 @DeleteMapping("/deletecartcust/{custid}")
	    public String d(@PathVariable long custid) {
//	     Cart cart = new Cart();
//	     cart.setCartid(cartId);
		 cartdao.deleteAllByCustid(custid);
	        return "done";
	 }
//	 
	 //order implementation
	 @Transactional
	 @PostMapping("/saveorder")
	 public void saveorder(@RequestBody orders order) {
		 
		 orderservice.saveorder(order);
		 System.out.println("saved order");
		 
	 }
	 
	 @GetMapping("getorder/{custid}")
	    public List<orders> getorder(@PathVariable Long custid) {
//	     Cart cart = new Cart();
//	     cart.setCartid(cartId);
	        return orderservice.getorderList(custid);
	 }

	    
	    //seller module
	    
	    @RequestMapping("/sellerregistration")
		public String   Sregistration(@RequestBody 	Seller seller)
		
		{   
	    	System.out.println("ada"+seller);
	    	sellerService.saveSellerr(seller);  
			return "save seller";
		}
	    
	    @PostMapping("/authenticateseller")
	    public ResponseEntity<AuthResponse> login( @RequestBody Seller seller) {
		  Optional<Seller> existingUser = sellerService.findByEmail(seller.getEmail());
		  
		  Seller user=existingUser.get();
	        if (existingUser != null && user.getPassword().equals(seller.getPassword())) {
	        	return ResponseEntity.ok(new AuthResponse(user.getId(), user.getFirstName()));
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	        }
		
	
	  }
}