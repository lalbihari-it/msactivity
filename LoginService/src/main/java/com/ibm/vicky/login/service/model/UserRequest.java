/**
 * 
 */
package com.ibm.vicky.login.service.model;

public class UserRequest {
	
	 private String userName;
	
	 private String password;
	
	 private String orderDetails;

	 private String authToken;
	 
	 private String transactionToken;

	 public String getUserName() {
			return userName;
		}

		public void setUserName(String username) {
			this.userName = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getOrderDetails() {
			return orderDetails;
		}

		public void setOrderDetails(String orderDetails) {
			this.orderDetails = orderDetails;
		}

	public String getAuthToken() {
		return authToken;
	}

	public String getTransactionToken() {
		return transactionToken;
	}

	public void setAuthToken(String token) {
		this.authToken=token;
	}

	public void setTransactionToken(String transactionToken) {
		this.transactionToken = transactionToken;
	}

}
