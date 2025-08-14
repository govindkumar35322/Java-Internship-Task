package com.task7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcConnection {

	private static final String username = "root";
	private static final String password = "govind18500";
	private static final String url = "jdbc:mysql://localhost:3306/employe_db";

	public static void main(String[] args) {

		try (Connection conn = DriverManager.getConnection(url, username, password);
				Scanner sc = new Scanner(System.in)) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(" Connected to database Successfully !");
			while (true) {
				System.out.println("\n=== Employee Menu ===");
				System.out.println("1. Add Employee");
				System.out.println("2. View All Employees");
				System.out.println("3. Update Employee Salary");
				System.out.println("4. Delete Employee");
				System.out.println("5. Exit");
				System.out.print("Choose: ");
				int choice = sc.nextInt();

				switch (choice) {
				case 1:
					addEmploye(conn, sc);
					break;
				case 2:
					viewEmploye(conn);
					break;
				case 3:
					updateEmploye(conn, sc);
					break;
				case 4:
					deleteEmploye(conn,sc); break;
						
				case 5:
					System.out.println(" Exiting");
					return;
				default:
					System.out.println("Invalid choice !");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void addEmploye(Connection conn, Scanner sc) throws SQLException {
		System.out.println("Enter Id");
		  int id=sc.nextInt();
		System.out.println("Enter Name");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("Enter position: ");
		String position = sc.nextLine();
		System.out.print("Enter salary: ");
		double salary = sc.nextDouble();
		String sql = "INSERT INTO employe (id,name, position, salary) VALUES (?,?, ?, ?)";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, position);
			stmt.setDouble(4, salary);
			stmt.executeUpdate();
			System.out.println(" Employee added!");
		}

	}

	private static void viewEmploye(Connection conn) throws SQLException {
		String sql = "select *from employe";
		try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
			System.out.println(" \n ====Employe List=====");
			while (rs.next()) {
				System.out.printf("%d | %s | %s | %.2f%n", rs.getInt("id"), rs.getString("name"),
						rs.getString("position"), rs.getDouble("salary"));
			}
		}
	}

	private static void updateEmploye(Connection conn, Scanner sc) throws SQLException {
		System.out.print("Enter Employee ID: ");
		int id = sc.nextInt();
		System.out.print("Enter new salary: ");
		double salary = sc.nextDouble();

		String sql = "UPDATE employe SET salary = ? WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setDouble(1, salary);
			stmt.setInt(2, id);
			int rows = stmt.executeUpdate();
			if (rows > 0)
				System.out.println(" Employee updated!");
			else
				System.out.println(" Employee not found!");

		}
	}

	private static void deleteEmploye(Connection conn, Scanner sc) throws SQLException {
		System.out.print("Enter Employee ID: ");
		int id = sc.nextInt();

		String sql = "DELETE FROM employe WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			int rows = stmt.executeUpdate();
			if (rows > 0)
				System.out.println(" Employee deleted!");
			else
				System.out.println("Employee not found!");
		}
	}

}
