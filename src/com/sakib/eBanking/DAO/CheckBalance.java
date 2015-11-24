package com.sakib.eBanking.DAO;

import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.NotBlank;

public class CheckBalance {

	@DecimalMin(message="Please Give Valid Number", value = "1")
	private String account_No;
	
	@NotBlank(message="Please Fillup")
	private String userName,password;
	
	public CheckBalance() {
		// TODO Auto-generated constructor stub
	}

	public CheckBalance(String account_No, String userName, String password) {
		
		this.account_No = account_No;
		this.userName = userName;
		this.password = password;
	}

	public String getAccount_No() {
		return account_No;
	}

	public void setAccount_No(String account_No) {
		this.account_No = account_No;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
