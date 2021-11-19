package com.cbankoue.booklist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="table_user")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String mobile;
	
	@JsonIgnore
	@Column(nullable = false)
	private String password;
	
//	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	public void setPassword(String password) {
		this.password = new BCryptPasswordEncoder().encode(password);
	}
}
