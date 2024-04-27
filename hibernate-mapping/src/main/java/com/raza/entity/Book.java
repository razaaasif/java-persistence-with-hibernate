package com.raza.entity;

public class Book {
	private String title;
	private String isbn;
	private String yearOfRelease;

	public Book() {
	}

	public Book(String title, String isbn, String yearOfRelease) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.yearOfRelease = yearOfRelease;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(String yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

}
