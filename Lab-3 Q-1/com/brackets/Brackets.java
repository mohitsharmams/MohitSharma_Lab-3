package com.brackets;

import com.brackets.balancing.BracketsBalance;
import java.util.Scanner;


public class Brackets {

	public static void main(String[] args) {

		System.out.println("\n****Brackets Balancing check algo****");

		String input;

		boolean status;

		Scanner sc = new Scanner(System.in);
		BracketsBalance bl = new BracketsBalance();

		System.out.println("Enter the String to check bracket balancing: ");
		input = sc.nextLine();

		status = bl.bracketsBalancing(input);

		if(status == false) {
			System.out.println("Entered string has Unbalanced Brackets");
		}

		if(status == true) {
			System.out.println("Entered string has Balanced Brackets");
		}

		sc.close();
	}



}
