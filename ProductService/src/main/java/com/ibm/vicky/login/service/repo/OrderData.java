/**
 * 
 */
package com.ibm.vicky.login.service.repo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrderData")
public class OrderData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name="order_details")
	private String orderDetails;

	@Column(name="auth_token")
	private String authToken;	
	
	@Column(name="transaction_token")
	private String transactionToken;
	
	@Column(name="status")
	private String status;
	
	public OrderData() {
		
	}
		

	public OrderData(String orderDetails, String authToken, String transactionToken, String status) {
		super();
		this.orderDetails = orderDetails;
		this.authToken = authToken;
		this.transactionToken = transactionToken;
		this.status = status;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getTransactionToken() {
		return transactionToken;
	}

	public void setTransactionToken(String transactionToken) {
		this.transactionToken = transactionToken;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
