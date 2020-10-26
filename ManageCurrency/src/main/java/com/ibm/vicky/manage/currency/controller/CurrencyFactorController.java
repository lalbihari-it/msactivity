package com.ibm.vicky.manage.currency.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.vicky.manage.currency.model.CurrencyConversionFactor;
import com.ibm.vicky.manage.currency.model.CurrencyConversionFactorDTO;
import com.ibm.vicky.manage.currency.service.CurrencyFactorService;


@RestController
@EnableEurekaClient
public class CurrencyFactorController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CurrencyFactorService currencyService;

	@GetMapping("/cf")
	public String welcomeMessage() {
		return "Welcome to Manage Currency Application";
	}
	
	@GetMapping("/cf/findAll")
	public List<CurrencyConversionFactor> allCountriesList() {
			
		return currencyService.getAllCountries();
	}
	
	@GetMapping("/cf/get/{countryCode}")
	public double getConversionFactor(@PathVariable String countryCode) {
		if(countryCode !=null) {
		logger.info("getConversionFactor : "+ countryCode);
		return currencyService.getConversionFactor(countryCode);
		}
		return 0;
	}

	@GetMapping("/cf/add/{countryCode}/{factor}")
	public ResponseEntity<?> addConversionFactor(@PathVariable String countryCode, @PathVariable double factor) {
		ResponseEntity<?> responseEntity = null;
		try {
			CurrencyConversionFactorDTO value = currencyService.addConversionFactor(countryCode, factor);
			if (value != null) {
				responseEntity = new ResponseEntity<CurrencyConversionFactorDTO>(value, HttpStatus.CREATED);
			} else {
				responseEntity = new ResponseEntity<String>("Exception occured while adding a conversation factor",
						HttpStatus.UNAUTHORIZED);
			}

		} catch (Exception exception) {
			responseEntity = new ResponseEntity<String>("{ Exception occured while adding a conversation factor :" + exception.getMessage() + "}",
					HttpStatus.CONFLICT);
		}

		return responseEntity;
	}
	
	@GetMapping("/cf/update/{countryCode}/{factor}")
	public ResponseEntity<?> updateConversionFactor(@PathVariable String countryCode, @PathVariable double factor) {
		ResponseEntity<?> responseEntity = null;
		try {
			CurrencyConversionFactorDTO value = currencyService.updateConversionFactor(countryCode, factor);
			if (value != null) {
				responseEntity = new ResponseEntity<CurrencyConversionFactorDTO>(value, HttpStatus.OK);
			} else {
				responseEntity = new ResponseEntity<String>("Exception occured while updating a conversation factor",
						HttpStatus.CONFLICT);
			}

		} catch (Exception exception) {
			responseEntity = new ResponseEntity<String>("{ Exception occured while updating a conversation factor :" + exception.getMessage() + "}",
					HttpStatus.CONFLICT);
		}

		return responseEntity;
	}
	
	@DeleteMapping("/cf/delete/{countryCode}")
	public ResponseEntity<?> deleteConversionFactor(@PathVariable String countryCode) {
		ResponseEntity<?> responseEntity = null;
		try {
			currencyService.deleteConversionFactor(countryCode);
				responseEntity = new ResponseEntity<CurrencyConversionFactor>(HttpStatus.OK);

		} catch (Exception exception) {
			responseEntity = new ResponseEntity<String>("{ Exception occured while deleting a conversation factor :" + exception.getMessage() + "}",
					HttpStatus.CONFLICT);
		}

		return responseEntity;
	}
}