package com.grocery;

public class Product implements Comparable<Product>{
	private String prodId;
	private String name;
	private String description;
	private int quantity;
	private float price;
	public Product(String pid,String name, String description, int quantity, float price) {
		super();
		this.prodId=pid;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}
	
	
	public String getProdId() {
		return prodId;
	}


	public void setProdId(String prodId) {
		this.prodId = prodId;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}
	
	public int compareTo(Product p) {
		return p.getQuantity()-this.getQuantity();
	}
	
	
}
