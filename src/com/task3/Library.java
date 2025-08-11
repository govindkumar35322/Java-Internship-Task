package com.task3;

import java.util.ArrayList;

public class Library {
private ArrayList<Book>books;

public Library() {
	books= new  ArrayList<Book>(); 
}

public void addBook(Book book) {
	books.add(book);
}
public void displayBooks() {
	for(Book book:books) {
		System.out.println(book);
	}
}

public boolean issueBook(String title,User user) {
	
	for(Book book:books) {
		if(book.getTitle().equalsIgnoreCase(title) && !book.isIssued()){
			book.isIssued();
			System.out.println("Book " + title + " issued to "+ user.getName());
			return true;
		}
	}
	System.out.println("Book " + title + " is not available .");
	return false;
}

public boolean returnBook(String title, User user) {
    for (Book book : books) {
        if (book.getTitle().equalsIgnoreCase(title)) {
            if (book.isIssued()) {
                book.returnBook(); // set isIssued = false
                System.out.println("Book '" + title + "' returned by " + user.getName());
                return true;
            } else {
                System.out.println("Book '" + title + "' was not issued to anyone.");
                return false;
            }
        }
    }

    System.out.println("Book '" + title + "' not found in library.");
    return false;
}




}
