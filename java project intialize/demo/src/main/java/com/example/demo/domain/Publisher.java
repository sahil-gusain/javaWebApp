package com.example.demo.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ID;

	private String publisher_name;
	private String Address;
	private String City;
	private String State;
	private Integer Zipcode;
	
	@OneToMany
	private Set<Book> books = new HashSet<Book>();

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getPublisher_name() {
		return publisher_name;
	}

	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public Integer getZipcode() {
		return Zipcode;
	}

	public void setZipcode(Integer zipcode) {
		Zipcode = zipcode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publisher other = (Publisher) obj;
		return ID == other.ID;
	}

	@Override
	public String toString() {
		return "Publisher [ID=" + ID + ", publisher_name=" + publisher_name + ", Address=" + Address + ", City=" + City
				+ ", State=" + State + ", Zipcode=" + Zipcode + "]";
	}
}
