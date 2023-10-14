package com.sts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sts.Dao.BookServices;
import com.sts.Entity.Book;

@RestController
public class Controller {
    @Autowired
	private BookServices bookServices;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBook(){
		List<Book> books=bookServices.getAllBook();
		if(books.size()<1)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.of(Optional.of(books));
	}
	
	
	@GetMapping("/Book/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id)
	{
		Book book=bookServices.getBookById(id);
		if(book==null)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.of(Optional.of(book));
	}
	
	@DeleteMapping("/book/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable ("id") int id)
	{
		try {
		bookServices.deleteById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
	
	
	@DeleteMapping("/book/deleteAll")
	public ResponseEntity<Void> deleteAll(){
		try {
			bookServices.deleteAll();
		}
		catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok().build();
		
	}
	
	
	@PostMapping("/book/add")
	public ResponseEntity<Void> addBook(@RequestBody Book book){
		try {
			bookServices.addBook(book);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("/book/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id,@RequestBody Book book){
		try {
		bookServices.UpdateBook(id,book);
	}
	catch(Exception e){
		e.printStackTrace();
		return ResponseEntity.badRequest().build();
	}
		return ResponseEntity.status(HttpStatus.IM_USED).build();
	}	
	
	
	
}
