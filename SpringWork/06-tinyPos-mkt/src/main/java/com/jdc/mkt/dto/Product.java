package com.jdc.mkt.dto;

public class Product {
	
	private int id;
	private String name;
	private int detialPrice;
	private int wholeSalsePrice;
	private Category category;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDetialPrice() {
		return detialPrice;
	}
	public void setDetialPrice(int detialPrice) {
		this.detialPrice = detialPrice;
	}
	public int getWholeSalsePrice() {
		return wholeSalsePrice;
	}
	public void setWholeSalsePrice(int wholeSalsePrice) {
		this.wholeSalsePrice = wholeSalsePrice;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
