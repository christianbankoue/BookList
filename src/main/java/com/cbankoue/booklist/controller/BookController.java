package com.cbankoue.booklist.controller;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbankoue.booklist.Exception.BookNotFoundException;
import com.cbankoue.booklist.entity.Book;
import com.cbankoue.booklist.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	private Logger logger = LoggerFactory.getLogger(BookController.class);

	@GetMapping
	private ResponseEntity<Collection<Book>> findAll(){
		
		return new ResponseEntity<Collection<Book>>(bookService.findAll(), HttpStatus.OK);
		
	}
	
	@GetMapping("{id}")
	ResponseEntity<Book> findById(@PathVariable Long id) {
		
		ResponseEntity<Book> entity = null;
		
		try {
			
			entity =  new ResponseEntity<Book>(bookService.findById(id), HttpStatus.OK);
		
		} catch (BookNotFoundException e) {
			logger.error("error " + e);
		}
		
		return entity;
	}
	
	@PostMapping("saveAll")
	ResponseEntity<Collection<Book>> saveAll(@RequestBody List<Book> books){
		
		ResponseEntity<Collection<Book>> entity =  new ResponseEntity<Collection<Book>>(bookService.saveAll(books), HttpStatus.CREATED);
		
		return entity;
	}
	
	@PostMapping
	ResponseEntity<Book> save(@RequestBody Book book){
		
		ResponseEntity<Book> entity =  new ResponseEntity<Book>(bookService.saveOrUpdate(book), HttpStatus.CREATED);
		
		logger.info("Book added successfully");
		
		return entity;
		
	}
	
	@PutMapping
	ResponseEntity<Book> update(@RequestBody Book book){
		
		ResponseEntity<Book> entity =  new ResponseEntity<Book>(bookService.saveOrUpdate(book), HttpStatus.CREATED);
		
		return entity;
		
	}
	
	@DeleteMapping("{id}")
	void delete(@PathVariable Long id){
		bookService.deleteById(id);
	} 
	
	
	
}
