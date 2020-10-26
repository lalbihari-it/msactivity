package com.ibm.vicky.currency.service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="managecurrency", fallback = CurrencyConversionFallBack.class)
public interface CurrencyConversionFeignClient {
	
	@RequestMapping(value ="/cf/get/{countryCode}")
	public Double calcCurrencyConversion(@PathVariable("countryCode") String countryCode);

}
