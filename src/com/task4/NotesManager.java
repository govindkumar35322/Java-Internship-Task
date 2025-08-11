package com.task4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NotesManager {

	public static final String File_name = "students.txt";

	public  static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choice;
		while (true) {
			System.out.println("======== Notes App ======");
			System.out.println(" 1. Add a Note");
			System.out.println("2. View Notes");
			System.out.println("3.Exit");
			System.out.println("Enter your Choice");

			choice = sc.nextInt();
			String note=sc.nextLine();

			switch (choice) {
			case 1:
				addNote(sc);
				break;
			case 2:
				viewNote();
				break;
			case 3:
				System.out.println("Exiting... Say  GoodBye!");
			default:
				System.out.println("Invalid Choice . try again.");

			}
		}

	}

	private static void addNote(Scanner sc) {
		System.out.println("Enter your note:");
		String note = sc.nextLine();

		try (FileWriter fw = new FileWriter(File_name, true)) {
			fw.write(note + System.lineSeparator());
			System.out.println("Note Saved Successfully! ");
		} catch (IOException e) {
			System.out.println("error writimg to file " + e.getMessage());
		}
	}

	
	private static void viewNote() {
		// TODO Auto-generated method stub
		try(FileReader fr=new FileReader(File_name);
				BufferedReader br =new BufferedReader(fr)){
			
			String line;
			boolean isEmpty=true;
			System.out.println("===your Notes=====");
			while((line=br.readLine()) !=null) {
				System.out.println("-"+line);
				isEmpty=false;
			}
		if(isEmpty) {
			System.out.println("(No notes found)");
			
		}
	}catch(FileNotFoundException e){
		System.out.println("No notes file found. Start by adding a note first.");
	}catch(IOException e){
		System.out.println("Error reading file: " + e.getMessage());
	}

}
}