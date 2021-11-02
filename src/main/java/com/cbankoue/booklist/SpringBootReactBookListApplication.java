package com.cbankoue.booklist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cbankoue.booklist.entity.Book;
import com.cbankoue.booklist.entity.User;
import com.cbankoue.booklist.repository.BookRepository;
import com.cbankoue.booklist.repository.RoleRepository;
import com.cbankoue.booklist.repository.UserRepository;
import com.cbankoue.booklist.service.BookService;

@SpringBootApplication
public class SpringBootReactBookListApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactBookListApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner commandLineRunner(UserRepository userRepository, RoleRepository roleRepository, BookService bookService) {
//		
//		return args -> {
//			Book book = new Book(
//					"Spring in Action", 
//					"Craig Walls", 
//					"https://images-na.ssl-images-amazon.com/images/I/51gHy16h5TL.jpg",
//					9789351197997L,
//					630.0,
//					"English",
//					"comedie");
//			
//			bookService.saveOrUpdate(book);
//		};
//	}

}
