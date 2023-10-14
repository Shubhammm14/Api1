package com.sts.Entity;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity

public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Book_Ids")
	private long id;
	@Column(name="Book_Names")
	private String name;
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JsonManagedReference
	private Author author;

	@Column(name="prices")
	private int price;
	
	
	

	public Book() {
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", id=" + id + ", author=" + author + ", price=" + price + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
