package com.task3;

import java.util.Date;

public class Book {
 private Long bookId;
 private String title;
 private  String bookAuthor;
 private String publishedDate;
 private String bookEdition;
 private double price;
 private boolean isIssued;
 public Book(Long bookId, String title, String bookAuthor, String publishedDate, String bookEdition, double price,
		boolean isIssued) {
	super();
	this.bookId = bookId;
	this.title = title;
	this.bookAuthor = bookAuthor;
	this.publishedDate = publishedDate;
	this.bookEdition = bookEdition;
	this.price = price;
	this.isIssued = isIssued;
 }
 public Long getBookId() {
	return bookId;
 }
 public void setBookId(Long bookId) {
	this.bookId = bookId;
 }
 public String getTitle() {
	return title;
 }
 public void setTitle(String title) {
	this.title = title;
 }
 public String getBookAuthor() {
	return bookAuthor;
 }
 public void setBookAuthor(String bookAuthor) {
	this.bookAuthor = bookAuthor;
 }
 public String getPublishedDate() {
	return publishedDate;
 }
 public void setPublishedDate(String publishedDate) {
	this.publishedDate = publishedDate;
 }
 public String getBookEdition() {
	return bookEdition;
 }
 public void setBookEdition(String bookEdition) {
	this.bookEdition = bookEdition;
 }
 public double getPrice() {
	return price;
 }
 public void setPrice(double price) {
	this.price = price;
 }
 public boolean isIssued() {
	return isIssued;
 }
 public void setIssued(boolean isIssued) {
	this.isIssued = isIssued;
 }
 @Override
 public String toString() {
	return "Book [bookId=" + bookId + ", title=" + title + ", bookAuthor=" + bookAuthor + ", publishedDate="
			+ publishedDate + ", bookEdition=" + bookEdition + ", price=" + price + ", isIssued=" + isIssued + "]";
 }
 public void issueBook() {
     this.isIssued = true;
 }

 public void returnBook() {
     this.isIssued = false;
 }

 
}
