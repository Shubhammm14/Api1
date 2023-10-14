package com.sts.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Author_Id")
	private int authorId;
	@Column(name="Author_Name")
	private String name;
	@Column(name="Author_Deg")
	private String degree;
	@Column(name="Author_Lang")
	private String language;
	@OneToOne(mappedBy="author")
	@JsonBackReference
	private Book book;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDegree() {
		return degree;
	}
	public Author() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Author [name=" + name + ", degree=" + degree + ", language=" + language + "]";
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	

}
