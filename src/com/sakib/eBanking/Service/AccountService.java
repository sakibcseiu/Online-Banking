package com.sakib.eBanking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakib.eBanking.DAO.Account;
import com.sakib.eBanking.DAO.AccountDAO;
import com.sakib.eBanking.DAO.CheckBalance;
import com.sakib.eBanking.DAO.CloseAccount;
import com.sakib.eBanking.DAO.DepositMoney;
import com.sakib.eBanking.DAO.MyTask;
import com.sakib.eBanking.DAO.TransferMoney;
import com.sakib.eBanking.DAO.WithdrawMoney;

@Service
public class AccountService {

	private AccountDAO accountDAO;

	@Autowired
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	public Account createAccount(Account account) {
		return accountDAO.createAccount(account);
	}
	
	public List<Account> showAllAccount() {
		
		return accountDAO.showAllAccountDAO();
	}
	public boolean depositAccount(DepositMoney account) {
	return accountDAO.depositAccount(account.getAccount_No(),account.getUserName(),account.getPassword(),account.getAmount());
		
	}
	public boolean closeAccount(CloseAccount account) {
		
	 return	accountDAO.closeAccount(account.getAccount_No(),account.getUserName(),account.getPassword());
		
	}
	public boolean withdrawMoney(WithdrawMoney account) {
	 return	accountDAO.withDrawMoney(account.getAccount_No(),account.getUserName(),account.getPassword(),account.getAmount());
		
	}
	public boolean transferMoney(TransferMoney account) {
	return	accountDAO.transferMoney(account.getFaccount_No(),account.getUserName(),account.getPassword(),account.getAmount(),account.getTaccount_No());
		
	}
	public int checkBalance(CheckBalance account) {
		// TODO Auto-generated method stub
		return accountDAO.checkBalance(account.getAccount_No(),account.getUserName(),account.getPassword());
	}
	public Account showMyAccountDAO(Object obj) {
		
		if (obj.getClass().getName().equals("com.sakib.eBanking.DAO.WithdrawMoney")) {
			WithdrawMoney with=(WithdrawMoney) obj;
			System.out.println("withder ok from OBject");
			return accountDAO.showMyAccountDAO(with.getAccount_No());
		}
		if (obj.getClass().getName().equals("com.sakib.eBanking.DAO.TransferMoney")) {
			TransferMoney with=(TransferMoney) obj;
			return accountDAO.showMyAccountDAO(with.getFaccount_No());
		}
		if (obj.getClass().getName().equals("com.sakib.eBanking.DAO.DepositMoney")) {
			DepositMoney with=(DepositMoney) obj;
			return accountDAO.showMyAccountDAO(with.getAccount_No());
		}
		System.out.println("withdraw not ok from OBject: "+obj.getClass().getName().toString());
		return new Account();
	}
	public List<MyTask> showMyTask(MyTask account) {
		// TODO Auto-generated method stub
		return accountDAO.showMyTask(account.getAccount_No());
	}
}
