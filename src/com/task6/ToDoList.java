package com.task6;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ToDoList extends JFrame {

	private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskField;
    private final String FILE_NAME = "tasks.txt";

    public ToDoList() {
        setTitle("📋 To-Do List");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Use a nicer look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        // Main layout
        setLayout(new BorderLayout(10, 10));
        ((JComponent) getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));
        taskField = new JTextField();
        taskField.setFont(new Font("Arial", Font.PLAIN, 16));
        add(taskField, BorderLayout.NORTH);

        // Task list
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskList.setFont(new Font("Arial", Font.PLAIN, 16));
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(taskList), BorderLayout.CENTER);
     // Buttons panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        JButton addButton = new JButton("➕ Add");
        JButton deleteButton = new JButton("🗑 Delete");
        JButton completeButton = new JButton("✅ Complete");

        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        deleteButton.setFont(new Font("Arial", Font.BOLD, 14));
        completeButton.setFont(new Font("Arial", Font.BOLD, 14));

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(completeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Load tasks from file
        loadTasksFromFile();
        // Button actions
        addButton.addActionListener(e -> addTask());
        deleteButton.addActionListener(e -> deleteTask());
        completeButton.addActionListener(e -> markTaskComplete());

        // Enter key adds task
        taskField.addActionListener(e -> addTask());
    }

    // Add task
    private void addTask() {
        String task = taskField.getText().trim();
        if (!task.isEmpty()) {
            taskListModel.addElement(task);
            taskField.setText("");
            saveTasksToFile();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a task!");
        }
    }
 // Delete task
    private void deleteTask() {
        int index = taskList.getSelectedIndex();
        if (index != -1) {
            taskListModel.remove(index);
            saveTasksToFile();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to delete!");
        }
    }

    // Mark task complete
    private void markTaskComplete() {
        int index = taskList.getSelectedIndex();
        if (index != -1) {
            String task = taskListModel.get(index);
            if (!task.startsWith("✔ ")) {
                taskListModel.set(index, "✔ " + task);
                saveTasksToFile();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to mark complete!");
        }
    }

    // Save tasks to file
    private void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < taskListModel.size(); i++) {
                writer.write(taskListModel.get(i));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load tasks from file
    private void loadTasksFromFile() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    taskListModel.addElement(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	public static void main(String[] args) {
		 SwingUtilities.invokeLater(() -> new ToDoList().setVisible(true));
}
}
