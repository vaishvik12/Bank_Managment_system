package com.sit.bankmanagement.model;

public class Account {
	private long accNo;
	private String name;
	private long mobNo;
	private String adharNo;
	private int age;
	private int pin;
	private double balance;
	
	
	public void setPin(int Pin) {
		this.pin = Pin;
	}
	
	public int getPin() {
		return pin;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String newName) {
		this.name = newName;
	}
	
	public long getAccNo() {
		return accNo;
	}
	
	public void setAccNo(long newAccNo) {
		this.accNo = newAccNo;
	}

	
	public long getMobNo() {
		return mobNo;
	}
	
	public void setMobNo(long newMobNo) {
		this.mobNo = newMobNo;
	}
	
	public String getAdharNo() {
		return adharNo;
	}
	
	public void setAdharNo(String newAdharNo) {
		this.adharNo = newAdharNo;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int newAge) {
		this.age = newAge;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double newBalance) {
		this.balance = newBalance;
	}
}
