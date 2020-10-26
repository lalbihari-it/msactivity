package com.ibm.vicky.manage.currency.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conversion_factor")
public class CurrencyConversionFactor {
	
	@Id
	@Column(name = "ID", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="COUNTRY_CODE",length = 5,nullable = false,unique=true)
	private String countryCode;
	
	@Column(name="CONVERSION_FACTOR",precision = 4,nullable = false)
	private double conversionFactor;
	
	
	public CurrencyConversionFactor() {
		
	}
	
	public CurrencyConversionFactor(String countryCode, double conversionFactor) {
		super();
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public double getConversionFactor() {
		return conversionFactor;
	}


	public void setConversionFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	
}
