package com.sakib.eBanking.DAO;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

public class MyTask {

	//@Digits(fraction=0, message="Please Give Valid Number", integer = 1)
	@DecimalMin(message="Please Give Valid Number", value = "1")
	private String account_No;
	private String operation,amount,balance,date;
	public MyTask() {
		// TODO Auto-generated constructor stub
	}
	public MyTask(String account_No, String operation, String amount,
			String balance, String date) {
		
		this.account_No = account_No;
		this.operation = operation;
		this.amount = amount;
		this.balance = balance;
		this.date = date;
	}
	public String getAccount_No() {
		return account_No;
	}
	public void setAccount_No(String account_No) {
		this.account_No = account_No;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
