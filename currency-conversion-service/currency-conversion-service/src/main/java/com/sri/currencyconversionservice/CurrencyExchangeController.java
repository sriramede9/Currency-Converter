package com.sri.currencyconversionservice;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sri.currencyconversionservice.data.CurrencyConversionBean;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	@GetMapping("/currency-exchange/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		
		Map<String,String> uriVariables=new HashMap();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000//currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);
		
		CurrencyConversionBean response = responseEntity.getBody();
		
		CurrencyConversionBean currencyConversionBean=new CurrencyConversionBean(response.getId(), from, to,response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
		return currencyConversionBean;
	}
	@GetMapping("/currency-exchange-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		
		CurrencyConversionBean response = currencyExchangeService.getConversionRate(from, to);
		
		logger.info("{}",response);
		
		CurrencyConversionBean currencyConversionBean=new CurrencyConversionBean(response.getId(), from, to,response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
		return currencyConversionBean;
	}
}
