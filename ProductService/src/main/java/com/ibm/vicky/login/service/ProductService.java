/**
 * 
 */
package com.ibm.vicky.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.vicky.login.service.repo.OrderData;
import com.ibm.vicky.login.service.repo.OrderRepo;

@Service
public class ProductService {
	
	@Autowired
	private OrderRepo repo;

	
	
	public boolean saveData(String orderDetails, String userName, String authToken, String txnToken) {
		repo.save(new OrderData(orderDetails,authToken,txnToken,"Success"));
	
		return true;
	}



	public boolean saveOrderData(UserRequest user) {
		repo.save(new OrderData(user.getOrderDetails(),user.getAuthToken(),user.getTransactionToken(),"Success"));
		
		return true;
	}



	

}