package com.ibm.vicky.manage.currency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.vicky.manage.currency.model.CurrencyConversionFactor;

@Repository
public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversionFactor, Long> {
	CurrencyConversionFactor findByCountryCode(String countryCode);

}