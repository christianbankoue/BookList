package com.cbankoue.booklist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="table_book")
@NoArgsConstructor
public class Book {
	


	public Book(String title, String author, String coverPhotoURL, Long isbnNumber, Double price, String language,
			String genre) {
		this.title = title;
		this.author = author;
		this.coverPhotoURL = coverPhotoURL;
		this.isbnNumber = isbnNumber;
		this.price = price;
		this.language = language;
		this.genre = genre;
	}

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String author;

	@Column(nullable = false)
	private String coverPhotoURL;

	@Column(nullable = false)
	private Long isbnNumber;

	@Column(nullable = false)
	private Double price;

	@Column(nullable = false)
	private String language;

	@Column(nullable = false)
	private String genre;
}
