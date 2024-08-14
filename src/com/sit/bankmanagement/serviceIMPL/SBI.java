package com.sit.bankmanagement.serviceIMPL;

import com.sit.backmanagement.service.RBI;
import com.sit.bankmanagement.model.Account;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SBI extends Account implements RBI {
	public SBI() {

	}

	Scanner scanner = new Scanner(System.in);
	Account useAccount = new Account();
	LocalDateTime date = LocalDateTime.now();// date and time object for timestamp
	boolean flag;

	@Override
	public boolean checkUser() {
		while (true) {
			System.out.println("Enter your Account number: ");
			String checkingAccNo = scanner.next();
//			scanner.nextLine();

			System.out.println("Enter your pin: ");
			int checkingPin = scanner.nextInt();
//			scanner.nextLine(); 

			if (checkingAccNo.equals(useAccount.getAccNo()) && checkingPin == useAccount.getPin()) {
				System.out.println("Account found!!");
				return true;
			} else {
				System.out.println("Account not found!" + "\nWould you like to create a new account with us."
						+ "\nIf yes then press 1, else press 2");

				int createAccountChoice = scanner.nextInt();
				scanner.nextLine();
				if (createAccountChoice == 1) {
					createAccount();
					continue;
				} else {
					return false;
				}
			}
		}
	}

	@Override
	public void createAccount() {
		System.out.println("Date and time\n " + date);// calling date object

		
		
		
		
		try {
		System.out.println("Enter your full name: ");
		String Name = scanner.nextLine();
		
		if(!Name.matches(".*\\d.*")) {
			useAccount.setName(Name);
		}else {
			throw new StringMismatchException();
		}
		}catch(StringMismatchException e) {
			System.err.println("Name can only contain Alphabatic charachters.");
			e.printStackTrace();
			return;
		}
		
		
		
		
		

		try {
		while (true) {
				System.out.println("Enter your pin: ");
				int Pin = scanner.nextInt();

				System.out.println("Renter you pin: ");
				int confirmPin = scanner.nextInt();

				if (Pin == confirmPin) {
					System.out.println("Pin succesfully created!");
					useAccount.setPin(Pin);
					break;
				} else {
					useAccount.setPin(Pin);
					System.out.println("Pin does not match!/Renter Pin: ");
					continue;
				}
			} 
		}catch (InputMismatchException e) {
			System.err.println("Only Digits allowed ");
			e.printStackTrace();
			return;
		}
		
		
		
		
		try {
		System.out.println("Enter your account number:");
		while (true) {
			long accNo = scanner.nextLong();
			int len = String.valueOf(accNo).length();
			if (len == 10){
				useAccount.setAccNo(accNo);
				break;	
			} else {
				throw new lengthException();
			}
		}
		}catch(lengthException e) {
			System.err.println("Length Of account number should be of 10 digits!");
			e.printStackTrace();
			return;
			
		}catch(InputMismatchException e) {
			System.err.println("Only numbers allowed!");
			e.printStackTrace();
			return;
		}
		
		
		
		

		try {
		System.out.println("Enter your mobile number:");
		while (true) {
			long mobNo = scanner.nextLong();
			int len = String.valueOf(mobNo).length();
			if (len == 10) {
				useAccount.setMobNo(mobNo);
				break;
				
			} else {
				throw new lengthException();
			}
		}
		}catch(lengthException e){
			System.err.println("Length Of your phone number should be of 10 digits!");
			e.printStackTrace();
			return;
		}catch(InputMismatchException e) {
			System.err.println("Only digits are allowed!");
			e.printStackTrace();
			return;
		}

		
		
		
		
		
		try {
		System.out.println("Enter you adhar number:");
		while (true) {
			String adharNo = scanner.nextLine();
			if(adharNo.matches(".*//d.*")) {
				throw new StringMismatchException();
			}
			int adharNoLength = adharNo.length();
			if (adharNoLength != 12) {
				throw new lengthException();
			} else {
				useAccount.setAdharNo(adharNo);
				break;
			}
		}
		}catch(StringMismatchException e) {
			System.err.println("Only digits allowed!");
			e.printStackTrace();
			return;
		}catch(lengthException e) {
			System.err.println("Length of adhar number should be 12!");
			e.printStackTrace();
			return;
		}
		
		
		
		
		
		

		try {
		System.out.println("Enter your age: " + "\n**Age should be greater than or equal to 18");
		while (true) {
			int age = scanner.nextInt();
			if (age < 18 && age > 120) {
				System.out.println(
						"You are not eligible to open" + " an account with us. Sorry for the Inconinince!");
				continue;
			} else {
				useAccount.setAge(age);
				break;
			}
		}
		}catch(InputMismatchException e){
			System.out.println("only digits allowed");
			e.printStackTrace();
			return;
		}

		System.out.println("Enter the amount of money you want to deposit:\n"
				+ "**To create your account, enter an amount of" + " 500 RS or more**");
		System.out.println("");

		while (true) {
			double balance = scanner.nextDouble();
			if (balance < 500) {
				System.out.println("Balance can't be less then 500!!!" + " Please enter an amount greater than 499");
				continue;
			} else {
				useAccount.setBalance(balance);
				System.out.println("Sucessfully made a new accoutnt!!" + "\n -------------------------------------");
				break;
			}
		}

		displayAllDetails();
		System.out.println("----------------------------------");

	}

	@Override
	public void displayAllDetails() {
		System.out.println("Date and time of creation of Account: " + date);
		System.out.println("Name: " + useAccount.getName());
		System.out.println("Account number: " + useAccount.getAccNo());
		System.out.println("Mobile Number: " + "+91" + useAccount.getMobNo());
		System.out.println("Adhar number: " + useAccount.getAdharNo());
		System.out.println("Age: " + useAccount.getAge());
		System.out.println("Balance " + useAccount.getBalance());
		System.out.println("-----------------------------------");
	}

	@Override
	public void depositeMoney() {
		System.out.println("Enter the amount you want to deposit: ");

		while (true) {
			int depositAmount = scanner.nextInt();
			if (depositAmount >= 1000) {
				useAccount.setBalance(useAccount.getBalance() + depositAmount);
				System.out.println("Updated balance: " + useAccount.getBalance());
				System.out.println("-----------------------------------");
				break;
			} else {
				System.out.println("Minimum amount that you can deposit is 1000 rs.");
				continue;
			}
		}
	}

	@Override
	public void withdarawl() {

		while (true) {
			System.out.println("Enter the amount you want to witdraw: ");
			int withdrawAmount = scanner.nextInt();
			if (withdrawAmount <= useAccount.getBalance()) {
				useAccount.setBalance(useAccount.getBalance() - withdrawAmount);
				System.out.println("Updated balance: " + useAccount.getBalance());
				if (useAccount.getBalance() <= 500) {
					System.out.println("Your balance have gone below the minimum maintaince "
							+ "amount. Please update your balance as soon as possible.");
				}
				System.out.println("-----------------------------------");
				break;
			} else {
				System.out.println("You don't have the funds required to " + "make this transaction!!");
				useAccount.getBalance();
				System.out.println("If you would like to continue press 1 else press 2");
				int transaction = scanner.nextInt();
				if (transaction == 1) {
					continue;
				} else {
					break;
				}

			}
		}
	}

	@Override
	public void balanceCheck() {
		System.out.println("Current balance: " + useAccount.getBalance());
		System.out.println("-----------------------------------");
	}

	@Override
	public void updateAccountDetails() {
		System.out.println("-----------------------------------");
		System.out.println("If you want to update your name press 1\n" + "If you want to update your pin press 2\n"
				+ "If you want to update your phone number press 3\n"
				+ "If you want to update your adhar number press 4\n" + "To exit press 5\n");
		int takeUpdate = scanner.nextInt();
		switch (takeUpdate) {
		case 1: {

		}

		}
	}

}
