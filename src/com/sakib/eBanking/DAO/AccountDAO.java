package com.sakib.eBanking.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.sql.DataSource;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("accountDAO")
public class AccountDAO {

	private NamedParameterJdbcTemplate jdbc;
	private JdbcTemplate jTemplate;
	java.util.Date dt = new java.util.Date();

	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private String date = sdf.format(dt);
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public AccountDAO() {

	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		jTemplate=new JdbcTemplate(dataSource);
		System.out.println("sakib hasan JDBC "+jdbc);
	}

	//start create new account
	public Account createAccount(Account account) {

		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("UserName", account.getUserName());
		params.addValue("Password", passwordEncoder.encode(account.getPassword()));
		//params.addValue("Password", account.getPassword());
		params.addValue("Amount", account.getAmount());
		params.addValue("Address", account.getAddress());
		params.addValue("Phone", account.getPhone());
		params.addValue("date", account.getDate());
		//BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(account);
		
		 jdbc.update("insert into account(UserName,Password,Amount,Address,Phone,Date_and_Time) values (:UserName, :Password,:Amount,:Address,:Phone,:date)", params);
		 Integer acc_no=jTemplate.queryForObject("select max(Account_No) from account", Integer.class);
	Account acc=jTemplate.queryForObject("select  *from account where Account_No="+acc_no, new RowMapper<Account>(){

		@Override
		public Account mapRow(ResultSet rs, int s) throws SQLException {
			
			Account account=new Account();
			account.setAccount_No(rs.getInt(1));
			account.setUserName(rs.getString(2));
			account.setPassword(rs.getString(3));
			account.setAmount(rs.getString(4));
			account.setAddress(rs.getString(5));
			account.setPhone(rs.getString(6));
			account.setDate(rs.getTimestamp(7).toString());
			
			
			
			jTemplate.update("insert into customer_task_details values (?,?,?,?,?)", account.getAccount_No(),"Created A/C",account.getAmount(),account.getAmount(),date);
			return account;
		}});
	return acc;
	
	}//end create new account
	
	
	//start show all current account
	public List<Account> showAllAccountDAO() {

		List<Account> listAccount = jdbc.query("select *from account",
				new RowMapper<Account>() {

					@Override
					public Account mapRow(ResultSet rs, int arg1)
							throws SQLException {
						Account account = new Account();
						account.setAccount_No(rs.getInt(1));
						account.setUserName(rs.getString(2));
						account.setPassword(rs.getString(3));
						account.setAmount(rs.getString(4));
						account.setAddress(rs.getString(5));
						account.setPhone(rs.getString(6));
						account.setDate(rs.getTimestamp(7).toString());

						
						
						return account;
					}
				});

		
		return listAccount;
	}//end show all current account

	//start deposit account
	public boolean depositAccount(String account_No, String userName,
			String password, String amount) {

		Integer cnt = jTemplate.queryForObject(
			    "SELECT count(*) FROM account WHERE Account_No = ? AND UserName=? and Password=?", Integer.class, account_No,userName,password);
		if (cnt>0) {
			//System.out.println("sakib ok");
			String orginalamount = jTemplate.queryForObject(
				    "SELECT Amount FROM account WHERE Account_No = ?", String.class, account_No);
			Integer aa=Integer.parseInt(orginalamount)+Integer.valueOf(amount);
			
			//System.out.println("amount "+aa);
			jTemplate.update("update account set Amount=? where Account_No=?", aa,account_No);
			jTemplate.update("insert into customer_task_details values (?,?,?,?,?)", account_No,"Deposit",amount,orginalamount,date);
			return true;
		}
		
		return false;
	}//end deposit account
	

	//start to close account
	public boolean closeAccount(String account_No, String userName,
			String password) {
		Integer cnt = jTemplate.queryForObject(
			    "SELECT count(*) FROM account WHERE Account_No = ? AND UserName=? and Password=?", Integer.class, account_No,userName,password);
		if (cnt>0) {
			jTemplate.update("delete from account where Account_No=?",account_No);
			return true;
		}
		
		return false;
	}//end close account

	//start withdraw money
	public boolean withDrawMoney(String account_No, String userName, String password,
			String amount) {
		
		Integer cnt = jTemplate.queryForObject(
			    "SELECT count(*) FROM account WHERE Account_No = ? AND UserName=? and Password=?", Integer.class, account_No,userName,password);
		if (cnt>0) {
			System.out.println("withdraw ok");
			String orginalamount = jTemplate.queryForObject(
				    "SELECT Amount FROM account WHERE Account_No = ?", String.class, account_No);
			Integer aa=Integer.parseInt(orginalamount)-Integer.valueOf(amount);
			if (aa>=0) {
				jTemplate.update("update account set Amount=? where Account_No=?", aa,account_No);
				
				jTemplate.update("insert into customer_task_details values (?,?,?,?,?)", account_No,"Withdraw",amount,orginalamount,date);
				return true;
			}
			
			
		}
		
		return false;
	}//end withdraw money

	//start transfer money
	public boolean transferMoney(String faccount_No, String userName,
			String password, String amount, String taccount_No) {
		
		Integer cnt = jTemplate.queryForObject(
			    "SELECT count(*) FROM account WHERE Account_No = ? AND UserName=? and Password=?", Integer.class, faccount_No,userName,password);
		
		Integer ct = jTemplate.queryForObject(
			    "SELECT count(*) FROM account WHERE Account_No = ?", Integer.class, taccount_No);
		
		
		if (cnt>0 && ct>0) {
			
			String famount = jTemplate.queryForObject(
				    "SELECT Amount FROM account WHERE Account_No = ?", String.class, faccount_No);
			
			
			
			String tamount = jTemplate.queryForObject(
				    "SELECT Amount FROM account WHERE Account_No = ?", String.class, taccount_No);
			
			Integer fmoney=Integer.parseInt(famount)-Integer.valueOf(amount);
			Integer tmoney=Integer.parseInt(tamount)+Integer.valueOf(amount);
			
			if (ct>0 && fmoney>=0) {
				
				jTemplate.update("update account set Amount=? where Account_No=?", fmoney,faccount_No);
				jTemplate.update("update account set Amount=? where Account_No=?", tmoney,taccount_No);
				jTemplate.update("insert into customer_task_details values (?,?,?,?,?)", faccount_No,"Transfer",amount,famount,date);
				return true;
			}
		
		}
		return false;
	}//end transfer money

	public List<MyTask> showMyTask(String account_no) {
		
		List<MyTask> listTask = jdbc.query("select *from customer_task_details where Account_No="+account_no,
				new RowMapper<MyTask>() {

					@Override
					public MyTask mapRow(ResultSet rs, int arg1)
							throws SQLException {
						MyTask task = new MyTask();
					
						task.setAccount_No(rs.getString(1));
						task.setOperation(rs.getString(2));
						task.setAmount(rs.getString(3));
						task.setBalance(rs.getString(4));
						task.setDate(rs.getTimestamp(5).toString());

						return task;
					}
				});

		
		return listTask;
	}

	public int checkBalance(String account_No, String userName, String password) {
		Integer cnt = jTemplate.queryForObject(
			    "SELECT count(*) FROM account WHERE Account_No = ? AND UserName=? and Password=?", Integer.class, account_No,userName,password);
		if (cnt>0) {
			Integer balance=jTemplate.queryForObject("select Amount from account where Account_No="+account_No,Integer.class);
			return balance;
		}
		
		return -1;
	}

	public Account showMyAccountDAO(String account_No) {
		Account acc=jTemplate.queryForObject("select  *from account where Account_No="+account_No, new RowMapper<Account>(){

			@Override
			public Account mapRow(ResultSet rs, int s) throws SQLException {
				
				Account account=new Account();
				account.setAccount_No(rs.getInt(1));
				account.setUserName(rs.getString(2));
				account.setPassword(rs.getString(3));
				account.setAmount(rs.getString(4));
				account.setAddress(rs.getString(5));
				account.setPhone(rs.getString(6));
				account.setDate(rs.getTimestamp(7).toString());
				return account;
			}});

		return acc;
	}
	
}
