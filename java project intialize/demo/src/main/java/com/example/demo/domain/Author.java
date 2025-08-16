package com.example.demo.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity 
public class Author {
	
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO )
  private Long ID;
  private String firstname;
  private String lastname;
  
  @ManyToMany(mappedBy = "authors")
  private Set<Book> books =new HashSet<>();

	public Set<Book> getBooks() {
		return books;
	}

	@Override
	public String toString() {
		return "Author [ID=" + ID + ", firstname=" + firstname + ", lastname=" + lastname + ", books=" + books + "]";
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
		Author other = (Author) obj;
		return Objects.equals(ID, other.ID);
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
