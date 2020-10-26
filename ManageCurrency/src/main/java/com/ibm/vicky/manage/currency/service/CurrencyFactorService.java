package com.ibm.vicky.manage.currency.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.vicky.manage.currency.model.CurrencyConversionFactor;
import com.ibm.vicky.manage.currency.model.CurrencyConversionFactorDTO;
import com.ibm.vicky.manage.currency.repository.CurrencyConversionRepository;

@Service
public class CurrencyFactorService {
	
	@Autowired
	CurrencyConversionRepository conversionRepo;
	
	public double getConversionFactor(String countryCode) {
		CurrencyConversionFactor conversionValue = conversionRepo.findByCountryCode(countryCode);
		if(null != conversionValue) {
			return conversionValue.getConversionFactor();
		}else {
			return 0;
		} 
	}
	
	public List<CurrencyConversionFactor> getAllCountries()
	{
		return conversionRepo.findAll();
	}
	

	public CurrencyConversionFactorDTO addConversionFactor(String countryCode,double factor) {
		CurrencyConversionFactor entity = new CurrencyConversionFactor(countryCode,factor);
		CurrencyConversionFactor convFactor = conversionRepo.saveAndFlush(entity);
		if(null !=convFactor) {
			return createConversionFactorResponseDTO(convFactor);
		} 
		return null;
	}

	public CurrencyConversionFactorDTO updateConversionFactor(String countryCode, double factor) {
		deleteConversionFactor(countryCode);
		CurrencyConversionFactor newValue = new CurrencyConversionFactor(countryCode,factor);
		CurrencyConversionFactor convFactor = conversionRepo.saveAndFlush(newValue);
		if(null !=convFactor) {
			return createConversionFactorResponseDTO(convFactor);
		} 
		return null;
	}

	public void deleteConversionFactor(String countryCode) {
		CurrencyConversionFactor entity=conversionRepo.findByCountryCode(countryCode);
		conversionRepo.deleteById(entity.getId());
	}
	
	
	private CurrencyConversionFactorDTO createConversionFactorResponseDTO( CurrencyConversionFactor convFactor) {
		CurrencyConversionFactorDTO cdto = new CurrencyConversionFactorDTO();
		cdto.setCountrycode(convFactor.getCountryCode());
		cdto.setId(convFactor.getId().intValue());
		cdto.setValue(convFactor.getConversionFactor());

		return cdto;
	}
}
