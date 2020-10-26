/**
 * 
 */
package com.ibm.vicky.login.service.model;

public class AuthenticationResponse {

	 private final String authToken;
	 
	 private final String transactionToken;

	    public AuthenticationResponse(String authToken, String transactionToken) {
	        this.authToken = authToken;
	        this.transactionToken = transactionToken;
	    }

		public String getAuthToken() {
			return authToken;
		}

		public String getTransactionToken() {
			return transactionToken;
		}
	    
}
