package com.task5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankingSystem {
	private static Map<Long, Account> accounts = new HashMap<>();
	static Scanner sc=new Scanner(System.in);
	
public static void main(String[] args) {
	Bank bank=new Bank();
	Bank bank1 = new Bank("B001", "SBIBank", "Main Branch", bank.generateIFSCCode());  //String bankId, String name, String branchName, String ifscCode
    System.out.println("Welcome to " + bank.getName());

    while (true) {
        System.out.println("\n===== Banking Menu =====");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Balance");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline
        switch (choice) {
        case 1: createAccount(); break;
        case 2: depositMoney(); break;
        case 3: withdrawMoney(); break;
        case 4: checkBalance(); break;
        case 5: System.out.println("Thank you! Goodbye."); return;
        default: System.out.println("Invalid choice. Try again.");
    }
    }
	
}

private static void checkBalance() {
	// TODO Auto-generated method stub
	System.out.print("Enter account number: ");
    Long accNo = sc.nextLong();
    Account account = accounts.get(accNo);

    if (account != null) {
        System.out.println("Current Balance: " + account.getBalance());
    } else {
        System.out.println("Account not found!");
    }

}

private static void withdrawMoney() {
	// TODO Auto-generated method stub
	System.out.print("Enter account number: ");
    Long accNo = sc.nextLong();
    Account account = accounts.get(accNo);

    if (account != null) {
        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    } else {
        System.out.println("Account not found!");
    }
}

private static void depositMoney() {
	// TODO Auto-generated method stub
	System.out.print("Enter account number: ");
    Long accNo = sc.nextLong();
    Account account = accounts.get(accNo);

    if (account != null) {
        System.out.print("Enter deposit amount: ");
        double amount = sc.nextDouble();
        account.deposit(amount);
    } else {
        System.out.println("Account not found!");
    }
}

private static void createAccount() {
	// TODO Auto-generated method stub
	 System.out.print("Enter customer name: ");
	 String name = sc.nextLine();
	 System.out.print("Enter customer customerId: ");
     Long customerId = sc.nextLong();
     System.out.print("Enter customer email: ");
     String email = sc.nextLine();
     System.out.print("Enter customer addres: ");
     String address = sc.nextLine();
     System.out.print("Enter customer mobile number: ");
     String contactNumber = sc.nextLine();
     
   
      Long Id =  (long) (accounts.size() + 1);
     Customer customer = new Customer(name,contactNumber,  email,address,Id);
     Account acc=new Account();
     Long accountNumber =   (long) (accounts.size() +acc.genrateAccountNumber());
     Account account = new Account(accountNumber, customer);   //Long accountNumber, double balance, Customer customer
     accounts.put(accountNumber, account);

     System.out.println("Account created! Account Number: " + accountNumber);
}
}
