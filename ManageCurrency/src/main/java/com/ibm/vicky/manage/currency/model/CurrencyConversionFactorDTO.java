package com.ibm.vicky.manage.currency.model;


public class CurrencyConversionFactorDTO {

	private int id;
	private String countrycode;
	private String countryName;
	private double value;
	

	public CurrencyConversionFactorDTO(int id, String countrycode, String countryName, double value) {
		super();
		this.id = id;
		this.setCountrycode(countrycode);
		this.setCountryName(countryName);
		this.setValue(value);
	}


	public CurrencyConversionFactorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CurrencyConversionFactorDTO(String countrycode, double value) {
		super();
		
		this.setCountrycode(countrycode);
		this.setValue(value);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ConcurrencyConversionDTO [id=" + id + ", countrycode=" + countrycode + ", value=" + value +"]";
	}


	public String getCountrycode() {
		return countrycode;
	}


	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public double getValue() {
		return value;
	}


	public void setValue(double d) {
		this.value = d;
	}
	

}
