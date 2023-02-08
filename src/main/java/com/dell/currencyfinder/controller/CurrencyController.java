package com.dell.currencyfinder.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.dell.currencyfinder.model.Currency;

@Controller
public class CurrencyController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String loadCurrencyForm(Currency currency) {
		return "currencyfinder.html";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/findCurrency")
	public String fetchCurrency(Currency currency) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		System.out.println("The country selected is "+ currency.getCountry());
		
		/*if(currency.getCountry().equalsIgnoreCase("India")) 
			currency.setCurr("INR"); 
		else if(currency.getCountry().equalsIgnoreCase("US")) 
			currency.setCurr("USD");
		else if(currency.getCountry().equalsIgnoreCase("UK"))  
			currency.setCurr("POUND");
		else
			currency.setCurr("EURO");*/
		
		//ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8082/currency/"+currency.getCountry(), String.class);
		//ResponseEntity<String> response = restTemplate.getForEntity("http://currencyservice-currency-finder.apps.ocp4.ds.blr.lab/currency/"+currency.getCountry(), String.class);
		ResponseEntity<String> response = restTemplate.getForEntity("http://currencyservice-blue-green-deployment.apps.ocp4.ds.blr.lab/currency/"+currency.getCountry(), String.class);
		
		String productsJson = response.getBody();
		System.out.println("CURRENCY FROM SERVICE IS "+productsJson);
		currency.setCurr(productsJson);
	
		return "currencydetails.html";
	}
}
