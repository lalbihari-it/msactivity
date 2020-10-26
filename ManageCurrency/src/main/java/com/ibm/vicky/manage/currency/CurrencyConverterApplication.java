package com.ibm.vicky.manage.currency;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.vicky.manage.currency.model.CurrencyConversionFactor;
import com.ibm.vicky.manage.currency.repository.CurrencyConversionRepository;

@SpringBootApplication
@EnableEurekaClient
public class CurrencyConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterApplication.class, args);
	}
	

@Autowired
	CurrencyConversionRepository repo;
	
	public Map<Integer,CurrencyConversionFactor> currencyMap = new HashMap<Integer, CurrencyConversionFactor>();

	@Bean
	Map<Integer, CurrencyConversionFactor> productSeeds() {
		return currencyMap;
	}
	@Bean
	CommandLineRunner clr( final ApplicationContext context)
	{
		return (s) -> {
			populateDB();
		};
	}
	
	public void populateDB()
	{
		CurrencyConversionFactor cf= new CurrencyConversionFactor("USD",73);
		currencyMap.put(1,cf);
		repo.save(cf);
		cf= new CurrencyConversionFactor("EUR",83);
		currencyMap.put(2,cf);
		repo.save(cf);
		cf= new CurrencyConversionFactor("AUS",75);
		currencyMap.put(3,cf);
		repo.save(cf);
		
	} 

	
}
