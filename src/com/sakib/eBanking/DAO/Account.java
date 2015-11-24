package com.sakib.eBanking.DAO;





import java.text.SimpleDateFormat;

import javax.management.loading.PrivateClassLoader;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class Account {

	@NotBlank(message="Please Fillup")
	private String userName, password, address;
	private int account_No;
	
	java.util.Date dt = new java.util.Date();

	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private String date = sdf.format(dt);
	//String date = (new java.util.Date()).toString();


	//@Digits(integer = 6, message = "Must be integer", fraction = 0)
	@DecimalMin(message="Must Be Decimal Number",value="1")
	private String amount, phone;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	

	public Account(String userName, String password, String address,
			String date, String amount, String phone) {
	
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.date = date;
		this.amount = amount;
		this.phone = phone;
	}


	public Account(String userName, String password, String address,
			int account_No, String date, String amount, String phone) {
		
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.account_No = account_No;
		this.date = date;
		this.amount = amount;
		this.phone = phone;
	}





	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAccount_No() {
		return account_No;
	}

	public void setAccount_No(int account_No) {
		this.account_No = account_No;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
