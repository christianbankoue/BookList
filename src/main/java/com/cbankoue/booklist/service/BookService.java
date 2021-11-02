package com.cbankoue.booklist.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cbankoue.booklist.Exception.BookNotFoundException;
import com.cbankoue.booklist.entity.Book;
import com.cbankoue.booklist.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	
	
	public Collection<Book> findAll() {
		return (Collection<Book>) bookRepository.findAll();
	}

	
	public Page<Book> findAll(Pageable pageable, String searchText) {
		return bookRepository.findAllBooks(pageable, searchText);
	}

	
	public Page<Book> findAll(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}

	
	public Book findById(Long id) throws BookNotFoundException {
		Book book = bookRepository.findById(id).orElse(null); 
		
		if (book == null) {
			throw new BookNotFoundException(String.format("Book not found with id %d", id));
		}
		
		return book;
	}

	public Book saveOrUpdate(Book book) {
		return bookRepository.saveAndFlush(book);
	}


	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}


	public Collection<Book> saveAll(List<Book> books) {
		// TODO Auto-generated method stub
		bookRepository.saveAllAndFlush(books);
		
		return books;
	}

	

}
