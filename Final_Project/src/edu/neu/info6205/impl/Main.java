package edu.neu.info6205.impl;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		
		// the number of threads to execute
		int N = 1;
		
		int total_gene = 0;
		double average_gene = 0;
		
		System.out.println("Please enter the number of threads to execute: ");
		N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			System.out.println();
			System.out.println("Thread " + (i+1) + " is starting.......");
			Thread t = new Execute();
			t.start();
			t.join();
			
			total_gene += Execute.finishedGenerationsCount;
			
			System.out.println("Thread " + (i+1) + " finished!");

			System.out.println("************************************************************************************************************************");
			System.out.println();
		}
		
		average_gene = (double)total_gene/(double)N;
		System.out.println("The average generations is " + average_gene);
				
	}
}
