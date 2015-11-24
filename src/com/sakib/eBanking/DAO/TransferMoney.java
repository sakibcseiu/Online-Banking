package com.sakib.eBanking.DAO;

import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.NotBlank;

public class TransferMoney {

	@DecimalMin(message="Please Give Valid Number", value = "1")
	private String faccount_No,taccount_No;
	
	@NotBlank(message="Please Fillup")
	private String userName,password;
	
	@DecimalMin(message="Please Give Valid Number", value = "1")
	private String amount;
	
	public TransferMoney() {
		// TODO Auto-generated constructor stub
	}
	public TransferMoney(String faccount_No, String taccount_No, String userName,
			String password, String amount) {
		
		this.faccount_No = faccount_No;
		this.taccount_No = taccount_No;
		this.userName = userName;
		this.password = password;
		this.amount = amount;
	}
	public String getFaccount_No() {
		return faccount_No;
	}
	public void setFaccount_No(String faccount_No) {
		this.faccount_No = faccount_No;
	}
	public String getTaccount_No() {
		return taccount_No;
	}
	public void setTaccount_No(String taccount_No) {
		this.taccount_No = taccount_No;
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}
