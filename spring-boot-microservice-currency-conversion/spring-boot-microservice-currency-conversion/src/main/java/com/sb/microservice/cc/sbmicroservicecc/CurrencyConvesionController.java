package com.sb.microservice.cc.sbmicroservicecc;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConvesionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeProxy;
	
	/*
	 * @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	 * public CurrencyConversionBean convertCurrency(@PathVariable String from
	 * ,@PathVariable String to,@PathVariable BigDecimal quantity) {
	 * 
	 * Map<String, String> uriVariables = new HashMap<>(); uriVariables.put("from",
	 * from); uriVariables.put("to", to);
	 * 
	 * ResponseEntity<CurrencyConversionBean> responseEntity = new
	 * RestTemplate().getForEntity(
	 * "http://localhost:8081/currency-exchange/from/{from}/to/{to}",
	 * CurrencyConversionBean.class, uriVariables);
	 * 
	 * CurrencyConversionBean response = responseEntity.getBody();
	 * 
	 * return new CurrencyConversionBean(response.getId(), from, to,
	 * response.getConversionMultiple(), quantity,
	 * quantity.multiply(response.getConversionMultiple()), response.getPort()); }
	 */
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	  public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
	      @PathVariable BigDecimal quantity) {

	    CurrencyConversionBean response = currencyExchangeProxy.retrieveExchangeValue(from, to);


	    return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
	        quantity.multiply(response.getConversionMultiple()), response.getPort());
	  }

}
