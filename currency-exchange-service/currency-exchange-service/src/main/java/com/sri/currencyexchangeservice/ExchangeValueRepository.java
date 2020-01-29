package com.sri.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.currencyexchangeservice.bean.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);
}
