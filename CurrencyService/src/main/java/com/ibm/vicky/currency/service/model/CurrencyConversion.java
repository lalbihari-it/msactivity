package com.ibm.vicky.currency.service.model;

import java.math.BigDecimal;

public class CurrencyConversion {
	  private String countryCode;
	  private BigDecimal amount;
	  
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}