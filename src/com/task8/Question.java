package com.task8;

public class Question {
	String level;
	String questionText;
	 String[] options;
	 char  correctAnswer;
	 public Question(String level, String questionText, String[] options, char correctAnswer) {
		super();
		this.level = level;
		this.questionText = questionText;
		this.options = options;
		this.correctAnswer = Character.toUpperCase(correctAnswer);
	 }
	 boolean isCorrect(char answer) {
		 return Character.toUpperCase(answer)==correctAnswer;
	 }
	 
}
