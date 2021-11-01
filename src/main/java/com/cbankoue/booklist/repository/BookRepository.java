package com.cbankoue.booklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cbankoue.booklist.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
