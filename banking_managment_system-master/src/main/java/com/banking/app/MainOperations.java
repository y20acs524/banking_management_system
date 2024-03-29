package com.banking.app;

import java.util.Scanner;

public class MainOperations {

	static Scanner s=new Scanner(System.in);
	public static void mainOper() {
		
		while(true) {
			System.out.println("Welcome to Banking Managment System:\n"+"1.Branch Details:\n"+"2.Employee Details:\n"
					+"3.Customer Details:\n"+"4.Account Details:\n"+"5.Loan Details");
						
		System.out.println("enter the input");
		int input=s.nextInt();
		
		switch(input){
		case 1:AllOperations.branchOperations();
		System.out.println("***********");
		break;
		case 2:AllOperations.employeeOperations();
		break;
		case 3:AllOperations.customerOperations();
		break;
		case 4:AllOperations.accountOperations();
		break;
		case 5:AllOperations.loanOperations();
		break;
		case 6:System.exit(0);
		}
		}
	}
}
