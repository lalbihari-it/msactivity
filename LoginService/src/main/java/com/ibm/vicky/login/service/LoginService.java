/**
 * 
 */
package com.ibm.vicky.login.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.vicky.login.service.filter.OrderFeignProxy;
import com.ibm.vicky.login.service.model.UserRequest;

@Service
public class LoginService {
	
	/*
	 * @Autowired LoadBalancerClient lbClient;
	 */
	@Autowired
	OrderFeignProxy feignProxy;
	
	
	public String getOrderFeign(String orderDetails, String userName , String authToken, String txnToken ) {

		//UserRequest request = createTokenRequest(orderDetails,userName,authToken, txnToken);
		String status = feignProxy.saveOrder(orderDetails, userName , authToken, txnToken);
		return status;

	}


	private UserRequest createTokenRequest(String orderDetails, String userName , String authToken, String txnToken ) {

				UserRequest request = new UserRequest(); 
				request.setAuthToken(authToken);
				request.setTransactionToken(txnToken);
				request.setOrderDetails(orderDetails);
				request.setUserName(userName);
			
		return request;
	}


	public String saveOrder(String orderDetails, String authToken, String transactionToken, String userName) {
		
		String status = feignProxy.saveOrder(orderDetails, userName , authToken, transactionToken);
		return status;
	}


	public String saveOrderData(UserRequest user) {
		String status = feignProxy.saveOrderData(user);
		return status;
	}
}

