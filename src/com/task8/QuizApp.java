package com.task8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class QuizApp {

	public static List<Question> loadQuestionFromFile(String fileName) throws IOException{
		List<Question> question=new ArrayList<>();
		try(BufferedReader br=new BufferedReader(new FileReader(fileName))){
			String line;
			while((line=br.readLine()) != null) {
				String[]parts=line.split("\\|");
				if(parts.length==7) {
					String level=parts[0];
					String questionText=parts[1];
					String[] options=Arrays.copyOfRange(parts,2, 6);
					char correctAnswer=parts[6].charAt(0);
					question.add(new Question(level,questionText,options,correctAnswer));
				}
			}
		}
		return question;
		
		
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		List<Question> allQuestion=loadQuestionFromFile("F:\\Eclipse Tool\\JavaInternship\\src\\com\\task8\\question.txt");
		System.out.println("Select Level : EASY / MEDIUM / HARD");
		String chosenLevel =sc.nextLine().toUpperCase();
	
		List<Question> filtered=new ArrayList<>();
		for(Question q:allQuestion) {
			if(q.level.equalsIgnoreCase(chosenLevel)) {
				filtered.add(q);
			}
		}
		Collections.shuffle(filtered);
		int score=0;
		System.out.println(" ==== Starting "+chosenLevel +"Quiz ==== \n");
		for(int i=0;i<filtered.size();i++) {
			Question q=filtered.get(i);
			System.out.println("Q" +(i+1) + ":" + q.questionText);
			for(String option :q.options) {
				System.out.println(option);
			}
			ExecutorService executors=Executors.newSingleThreadExecutor();
			Future <String> future=executors.submit(()->{
				 System.out.print("Your answer: ");
	                return sc.nextLine();
			});
			String answer="";
			try {
				answer=future.get(60,TimeUnit.SECONDS);
				
			}catch(TimeoutException e) {
				System.out.println(" \n Time's up !");
			    future.cancel(true);
			}catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
			
			}finally {
				executors.shutdownNow();
			}
			
			if(!answer.isEmpty() && q.isCorrect(answer.charAt(0))) {
				System.out.println("Correct \n");
				score++;
			}
			else if( !answer.isEmpty()) {
				System.out.println("Wrong !  Correct Answer"+q.correctAnswer);
			}
		}
		System.out.println("=== Quiz Completed! ===");
        System.out.println("Your Score: " + score + "/" + filtered.size());

        if (score == filtered.size()) {
            System.out.println(" Excellent! Perfect score!");
        } else if (score >= filtered.size() / 2) {
            System.out.println(" Good job! Keep practicing.");
        } else {
            System.out.println(" Better luck next time!");
        }

        sc.close();
	}
		
}
