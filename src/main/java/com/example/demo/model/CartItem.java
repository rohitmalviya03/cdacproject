package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long cartitemid;
	 private Long custid;
		public Long getCustid() {
		return custid;
	}

	public void setCustid(Long custid) {
		this.custid = custid;
	}

		public Long getCartitemid() {
		return cartitemid;
	}

	public void setCartitemid(Long cartitemid) {
		this.cartitemid = cartitemid;
	}

		private String name;

		private long productid;
	    public long getProductid() {
			return productid;
		}

		public void setProductid(long productid) {
			this.productid = productid;
		}

		private double price;
//	    private long cust_id;
//	    public long getCust_id() {
//			return cust_id;
//		}
//
//		public void setCust_id(long cust_id) {
//			this.cust_id = cust_id;
//		}

		private int quantity;
	   
		// @ManyToOne(fetch = FetchType.LAZY)
	 //   @JoinColumn(name = "cart_id", nullable = false)
	   // private Cart cart;
//	    @ManyToOne
//	    @JoinColumn(name="customer_id")
//	    private Customer customer;
//	    
//	public Cart getCart() {
//			return cart;
//		}
//
//		public void setCart(Cart cart) {
//			this.cart = cart;
//		}


	

//	public Customer getCustomer() {
//			return customer;
//		}
//
//		public void setCustomer(Customer customer) {
//			this.customer = customer;
//		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
