package com.task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentRecordManagementSystem {
	static final String FILE_NAME = "students.txt";
	 static Scanner sc =new Scanner(System.in);
	 static ArrayList<Student> studentList= new ArrayList<>();
	public static void main(String[] args) {
		
		
		int choice;
		//loadFromFile();
		do {
		System.out.println("\n------ Student Record Management System ------");
		 System.out.println("======================================");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student by Roll No");
        System.out.println("4. Update Student by Roll No");
        System.out.println("5. Delete Student by Roll No");
        System.out.println("6. Exit");
        System.out.println("======================================");
        System.out.print("Enter your choice: ");
       
        choice = validateIntInput();
			switch(choice) {
			case 1: addStudent();break;
			case 2: viewStudents();break;
			case 3: searchStudent();break;
			case 4: updateStudent();break;  
			case 5:  deleteStudent();break;
			case 6:
				System.out.println("Existing Goodbye !"); break;
			default:
				System.out.println("Invalid Choice");
			}
		}while(choice !=6);
	}
		 static void addStudent() {	
		Student st=new Student();
	
		System.out.print("Enter Roll No: ");	
		st.setRollNo(validateIntInput());
		
		System.out.print("Enter Name: ");
        st.setName(sc.next());

        System.out.print("Enter Age: ");
        st.setAge(validateIntInput());

        System.out.print("Enter Address: ");
        st.setAddress(sc.next());

        System.out.print("Enter Email: ");
        String email = sc.next();
        while (!isValidEmail(email)) {
            System.out.print("❌ Invalid email. Enter again: ");
            email = sc.next();
        }
        st.setEmail(email);

        System.out.print("Enter Marks (0–100): ");
        int marks = validateIntInput();
        while (marks < 0 || marks > 100) {
            System.out.print("❌ Marks must be between 0 and 100. Enter again: ");
            marks = validateIntInput();
        }
        st.setMarks(marks);

        studentList.add(st);
        saveToFile();
        System.out.println("✅ Student added successfully!");
		
		
		 }	
		
		 static void viewStudents() {
		        if (studentList.isEmpty()) {
		            System.out.println("⚠ No student records found.");
		        } else {
		            for (Student s : studentList) {
		                System.out.println(s);
		            }
		        }
		    }
		
		    static void searchStudent() {
		        System.out.print("Enter Roll No to search: ");
		        int roll = validateIntInput();
		        for (Student s : studentList) {
		            if (s.getRollNo() == roll) {
		                System.out.println("✅ Student found:\n" + s);
		                return;
		            }
		        }
		        System.out.println("❌ Student not found.");
		    }
	
		    static void updateStudent() {
		        System.out.print("Enter Roll No to update: ");
		        int roll = validateIntInput();
		        for (Student s : studentList) {
		            if (s.getRollNo() == roll) {
		                System.out.print("Enter New Name: ");
		                s.setName(sc.next());

		                System.out.print("Enter New Age: ");
		                s.setAge(validateIntInput());

		                System.out.print("Enter New Address: ");
		                s.setAddress(sc.next());

		                System.out.print("Enter New Email: ");
		                String email = sc.next();
		                while (!isValidEmail(email)) {
		                    System.out.print("❌ Invalid email. Enter again: ");
		                    email = sc.next();
		                }
		                s.setEmail(email);

		                System.out.print("Enter New Marks (0–100): ");
		                int marks = validateIntInput();
		                while (marks < 0 || marks > 100) {
		                    System.out.print("❌ Marks must be between 0 and 100. Enter again: ");
		                    marks = validateIntInput();
		                }
		                s.setMarks(marks);

		                saveToFile();
		                System.out.println("✅ Student updated.");
		                return;
		            }
		        }
		        System.out.println("❌ Student not found.");
		    }
		
		    static void deleteStudent() {
		        System.out.print("Enter Roll No to delete: ");
		        int roll = validateIntInput();
		        Iterator<Student> iterator = studentList.iterator();
		        while (iterator.hasNext()) {
		            if (iterator.next().getRollNo() == roll) {
		                iterator.remove();
		                saveToFile();
		                System.out.println("✅ Student deleted.");
		                return;
		            }
		        }
		        System.out.println("❌ Student not found.");
		    }
		    static void saveToFile() {
		        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
		            oos.writeObject(studentList);
		        } catch (IOException e) {
		            System.out.println("❌ Error saving to file.");
		        }
		    }
		
		    static void loadFromFile() {
		        File file = new File(FILE_NAME);
		        if (file.exists()) {
		            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
		                studentList = (ArrayList<Student>) ois.readObject();
		            } catch (IOException | ClassNotFoundException e) {
		                System.out.println("⚠ Failed to load previous data.");
		            }
		        }
		    }
		
		    static boolean isValidEmail(String email) {
		        return Pattern.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$", email);
		    }
		    static int validateIntInput() {
		        while (!sc.hasNextInt()) {
		            System.out.print("❌ Invalid input. Please enter a number: ");
		            sc.next();
		        }
		        return sc.nextInt();
		    }
		
		
	}

