package com.model;

public class Book {
	    private int bookid ;
	    private String title ;
	    private String author;
	    private String publisher;
	    private float price ;
		public Book() {			
			// TODO Auto-generated constructor stub
		}
		public Book(int bookid, String title, String author, String publisher, float price) {
			this.bookid = bookid;
			this.title = title;
			this.author = author;
			this.publisher = publisher;
			this.price = price;
		}
		public int getBookid() {
			return bookid;
		}
		public void setBookid(int bookid) {
			this.bookid = bookid;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getPublisher() {
			return publisher;
		}
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}

}
