package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.orderDao;
import com.example.demo.model.orders;

@Service
public class orderService {

	@Autowired
	orderDao orderRepo;
	
	public void saveorder(orders order) {
		orderRepo.save(order);
		
	}
	public List<orders> getorderList(long custid){
		return orderRepo.findByCustid(custid);
		
	}
	
	
}
