package com.grocery;

public class Customer {
	private int customerId;
	private String name;
	private String email;
	private String password;
	private String address;
	private String contact;
	private boolean active;
	
	public Customer(int id,String name, String email, String password, String address, String contact) {
		super();
		this.customerId=id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contact = contact;
		this.active = true;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int id) {
		this.customerId = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Customer [id= "+customerId+", name=" + name + ", email=" + email + ", password=" + password + ", address=" + address
				+ ", contact=" + contact + ", active=" + active + "]";
	}
	
	
}
