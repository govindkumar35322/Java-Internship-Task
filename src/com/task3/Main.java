package com.task3;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Library lib=new Library();
     
    Scanner sc=new Scanner(System.in);
   // java.util.Date currentDate = java.util.Date.valueOf(LocalDate.now()); 
    lib.addBook(new Book(1001L, "Java Programming", "James Gosling", "2020-05-15", "First Edition", 499.99, false));
    lib.addBook(new Book(1002L, "Clean Code", "Robert C. Martin", "2018-08-01", "2nd Edition", 599.00, false));
    lib.addBook(new Book(1003L, "Effective Java", "Joshua Bloch", "2017-12-27", "3rd Edition", 699.50, false));
    lib.addBook(new Book(1004L, "Design Patterns", "Erich Gamma","2004-10-21", "Illustrated", 799.00, false));
    lib.addBook(new Book(1005L, "Algorithms", "Thomas H. Cormen", "2009-07-31", "3rd Edition", 899.99, false));

    
    User user=new User(1121l,"Govind kUmar");
    int choice;
    do {
    	 System.out.println("\n======= Library Menu ===============");
         System.out.println("1. Display Books");
         System.out.println("2. Issue Book");
         System.out.println("3. Return Book");
         System.out.println("0. Exit");
         System.out.println("================================");
         System.out.print("Enter your choice: ");
         choice = sc.nextInt();
         sc.nextLine();
         
         switch(choice){
        	 case 1:
        		 lib.displayBooks();
        		 break;
        	 case 2:
        		 System.out.print("Enter book title to issue: ");
                 String issueTitle = sc.nextLine();
                 lib.issueBook(issueTitle, user);
                 break;
             case 3:
                 System.out.print("Enter book title to return: ");
                 String returnTitle = sc.nextLine();
                 lib.returnBook(returnTitle, user);
                 break;
             case 0:
                 System.out.println("Exiting Library System. Goodbye!");
                 break;
             default:
                 System.out.println("Invalid choice. Try again.");
         }
     } while (choice != 0);
	 
        		 
         }
   
    
	}


