package com.demo.cart;

public class Items {

	private String name;
	private double pricePerUnit;
	private int quantity;

	public Items() {
		// TODO Auto-generated constructor stub
	}
	
	public Items(String name, double pricePerUnit, int quantity) {
		this.name = name;
		this.pricePerUnit = pricePerUnit;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Item :[ Name :"+name+" Price per Unit :" +pricePerUnit+ " Quantity : "+quantity+"]";
	}
	
}
