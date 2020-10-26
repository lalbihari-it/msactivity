package com.ibm.vicky.currency.service.service;

import org.springframework.stereotype.Component;

@Component
public class CurrencyConversionFallBack implements CurrencyConversionFeignClient{

	@Override
	public Double calcCurrencyConversion(String countryCode) {
		System.out.println("FallBack:");
		double amount = 0.0;
		return amount;
	}
	
	

}
