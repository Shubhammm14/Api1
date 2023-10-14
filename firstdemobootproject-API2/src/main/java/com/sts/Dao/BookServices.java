package com.sts.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sts.Entity.Book;
@Component
public class BookServices implements Services {
	@Autowired
	 private UserRepository userRepository;

	@Override
	public List<Book> getAllBook() {
		 List<Book> books = new ArrayList<>();
		    Iterable<Book> itr = userRepository.findAll();
		    Iterator<Book> irl = itr.iterator();
		    while (irl.hasNext()) {
		        books.add(irl.next());
		    }
		    return books; // Return the list of books
		}

	@Override
	public Book getBookById(int id) {
		Optional<Book>option= userRepository.findById(id);
		return option.get();
	}

	@Override
	public int addBook(Book book) {
		userRepository.save(book);
		return 1;
	}

	@Override
	public int deleteById(int id) {
	userRepository.deleteById(id);	
	return 1;
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
	   userRepository.deleteAll();
		return 1;
	}

	@Override
	public int UpdateBook(int id, Book bok) {
		// TODO Auto-generated method stub
		Optional<Book> option=userRepository.findById(id);
		Book book=option.get();
		book=bok;
		return 1;
	}
}
