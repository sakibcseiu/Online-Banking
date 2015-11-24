package com.sakib.eBanking.DAO;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotBlank;

public class CloseAccount {

	@NotBlank(message="Please Fillup")
	private String userName,password;
	
	@DecimalMin(message="Please Give Valid Number", value = "1")
	private String account_No;

	public CloseAccount() {
		
	}
	public CloseAccount(String userName, String password, String account_No) {
		
		this.userName = userName;
		this.password = password;
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
	public String getAccount_No() {
		return account_No;
	}
	public void setAccount_No(String account_No) {
		this.account_No = account_No;
	}
	
	
}
