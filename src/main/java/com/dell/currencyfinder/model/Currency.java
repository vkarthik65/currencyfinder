package com.dell.currencyfinder.model;

public class Currency {
	
	private String country;
	private String curr = "";
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCurr() {
		return curr;
	}
	public void setCurr(String curr) {
		this.curr = curr;
	}
}
