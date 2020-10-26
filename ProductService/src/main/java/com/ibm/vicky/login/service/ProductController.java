/**
 * 
 */
package com.ibm.vicky.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.vicky.login.service.repo.OrderRepo;
import com.ibm.vicky.login.service.util.JwtUtil;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;

	@Autowired
	private JwtUtil util;
	
	@Autowired
	private OrderRepo repo;
	
	@RequestMapping(value = "/order")
	public String order() {
		return "Welcome to Product Service";
	}
	

	
	//@RequestMapping(value = "/saveOrderData", method = RequestMethod.POST)
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	//public String saveOrderData(@RequestBody UserRequest user) {
	public String saveOrderData(@RequestBody UserRequest user) {
		if(user != null) {
		System.out.println("In save method " + user.getTransactionToken() + " " + user.getUserName());
		boolean isValidTransactionToken = isValidTransactionToken(user.getTransactionToken(), user.getUserName());
		
		if(isValidTransactionToken) {
			boolean tokenResponse = service.saveOrderData(user);
			if (tokenResponse == true) 
				return "Order saved successfully!!";
			 else 
				return "Order not saved";
		}else 
			return "Transaction Token is not valid!!";
		}
		return "User Data is empty";
	}

	private boolean isValidTransactionToken(String txnToken, String userName) {

		boolean valid = false;
		String name = null;
		try {
			
			if(txnToken != null) {
				System.out.println("Transaction token not null...");
				if(util.isTokenExpired(txnToken)) {
					System.out.println("Transaction token expired...");
					return false;
				}
				if(null != repo.findByTransactionToken(txnToken)) { 
					System.out.println("Transaction token already exist in db..");
					return false;
				}
				name = util.extractUsername(txnToken);
				System.out.println("Name " + name + " " + userName);
				if (name.equals(userName)) {
					System.out.println("Valid Token");
					return true;
				}
					
			}
		}catch (Exception e) {
			System.out.println("Transaction Token not valid"+ e);
		}
		return valid;
	}
}