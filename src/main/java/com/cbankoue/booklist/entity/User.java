package com.cbankoue.booklist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	@Column(nullable = false)
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
}
