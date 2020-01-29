package com.sri.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sri.currencyconversionservice.data.CurrencyConversionBean;

//@FeignClient(name = "currency-exchange-service",url = "localhost:8000")
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeService {

	
//	@GetMapping("/currency-exchange/from/{from}/to/{to}")
//	public CurrencyConversionBean getConversionRate(@PathVariable("from") String from, @PathVariable("to") String to);

	@GetMapping("currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean getConversionRate(@PathVariable("from") String from, @PathVariable("to") String to);
}
