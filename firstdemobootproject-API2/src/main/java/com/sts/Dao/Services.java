package com.sts.Dao;

import java.util.List;
//import java.util.Optional;

import com.sts.Entity.Book;

public interface Services {
	
	public List<Book> getAllBook();
	public Book getBookById(int id);
	public int addBook(Book book);
	public int deleteById(int id);
	public int deleteAll();
	public int UpdateBook(int id,Book book);
	
}
