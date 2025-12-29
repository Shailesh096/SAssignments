package com.sunbeam.menu;

import java.util.Scanner;

public class AdminMenu {
	private static int adminMenuOptions(Scanner sc) {
		System.out.println("**********Admin Menu**************");
		System.out.println("0.Logout");
		System.out.println("1.Create Quiz");
		System.out.println("2.List Quizzes");
		return sc.nextInt();
		
	}
	public static void adminMenu(Scanner sc) {
		int choice;
		while((choice=adminMenuOptions(sc))!=0) {
			switch(choice) {
			case 1:
				System.out.println("Create Quiz selected");
				break;
			case 2:
				System.out.println("Create list Quizzes selected");
				break;
			default:
				System.out.println("Wrong Choice");
				
			}
		}
		
	}

}
