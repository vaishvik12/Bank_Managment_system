package com.sit.bankmanagement.client;

import com.sit.bankmanagement.serviceIMPL.SBI;
import com.sit.bankmanagement.model.Account;
import com.sit.backmanagement.service.RBI;
import java.util.Scanner;

public class Main extends SBI {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		RBI bank = new SBI();

		System.out.println("Welcome to SBI!!");

		while (true) {
			System.out.println("To use the ATM press 1"
					+ " \n To Exit press 2"
					+ "\n Enter your choice: ");
			int choose = scanner.nextInt();
			if (choose == 1) {
				System.out.println(
						"To open a new account press 1"
						+ "\nTo deposit money press 2"
						+ "\n To Witdraw money press 3"
						+ "\n To check balance press 4"
						+ "\n To check your details press 5"
						+ "\n For exit press 6"
						+ "\nEnter your choice: ");

				int choice = scanner.nextInt();

				switch (choice) {
				case 1: {
					bank.createAccount();
					break;
				}
				case 2: {
					if(bank.checkUser() == true) {
					bank.depositeMoney();
					break;
					}else {
						break;
					}
				}
				case 3: {
					if(bank.checkUser() == true) {
					bank.withdarawl();
					break;
					}else {
						break;
					}
				}
				case 4: {
					if(bank.checkUser() == true) {
					bank.balanceCheck();
					break;
					}else {
						break;
					}
				}
				case 5: {
					if (bank.checkUser() == true) {
					bank.displayAllDetails();
					break;
					}else {
						break;
					}
				}
				case 6: {
					System.out.println("Would you like to continue?\n");
					break;
				}
				default: {
					System.out.println("Wrong Input");
					continue;
				}
				}
			} else {
				System.out.println("Thanks for using our services."
						+ " Please visit again.");
				break;
			}


		}

	}
}
