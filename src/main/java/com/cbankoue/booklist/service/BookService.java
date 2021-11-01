package com.cbankoue.booklist.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

	
	public Optional<Book> findById(Long id) {
		return bookRepository.findById(id);
	}

	
	public Book saveOrUpdate(Book book) {
		return bookRepository.save(book);
	}

	

}
