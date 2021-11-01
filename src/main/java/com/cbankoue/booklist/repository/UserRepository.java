package com.cbankoue.booklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.cbankoue.booklist.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	ResponseEntity<User> findByEmail(String username);

}
