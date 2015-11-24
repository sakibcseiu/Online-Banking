package com.sakib.eBanking;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sakib.eBanking.DAO.Account;
import com.sakib.eBanking.DAO.CheckBalance;
import com.sakib.eBanking.DAO.CloseAccount;
import com.sakib.eBanking.DAO.DepositMoney;
import com.sakib.eBanking.DAO.MyTask;
import com.sakib.eBanking.DAO.TransferMoney;
import com.sakib.eBanking.DAO.WithdrawMoney;
import com.sakib.eBanking.Service.AccountService;

@Controller
public class AccountController {

	private AccountService accountService;

	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping("/showAllAccount")
	public String displayAllAcoount(Model model) {

		List<Account> listAccounts = accountService.showAllAccount();
		model.addAttribute("accounts", listAccounts);

		
		return "allAcc";
	}
	@RequestMapping("/task")
	public String taskInfo(Model model) {

		model.addAttribute(new MyTask());

		return "taskInfoForm";
	}
	@RequestMapping("/showTask")
	public String showTask(Model model,@Valid MyTask account,BindingResult result) {

		
		if (result.hasErrors()) {
			return "taskInfoForm";
		}
		
			List<MyTask> listAccounts = accountService.showMyTask(account);
			
			if (listAccounts.size()>0) {
				model.addAttribute("tasks", listAccounts);
	
				return "taskInfo";
			}
			result.rejectValue("account_No", "invalid", "Invalid Account No");
			return "taskInfoForm";
			
			
	}
	
	@RequestMapping("/createAccount")
	public String createAcoount(Model model) {

		model.addAttribute(new Account());

		return "createAcc";
	}
	@RequestMapping("/doCreateAcc")
	public String doCreateAcoount(Model model,@Valid Account account,BindingResult result) {

		if (result.hasErrors()) {
			return "createAcc";
		}
		Account acc=accountService.createAccount(account);
		model.addAttribute("myaccount", acc);

		return "createdAcc";
	}
	
	
	@RequestMapping("/depositAccount")
	public String depositAcoount(Model model) {

		model.addAttribute(new DepositMoney());

		return "depositAcc";
	}
	
	@RequestMapping("/okDeposit")
	public String okDeposit(Model model,@Valid DepositMoney account,BindingResult result) {

		if (result.hasErrors()) {
			return "depositAcc";
		}
		if (accountService.depositAccount(account)) {
			Account acc	=accountService.showMyAccountDAO(account);
			model.addAttribute("myaccount", acc);
			return "depositedAcc";
		}
		model.addAttribute("error", "Invalid Account Number, UserName or Password");
			return "depositAcc";
		
	}
	@RequestMapping("/checkBalance")
	public String checkBalance(Model model) {

		model.addAttribute(new CheckBalance());

		return "checkBalance";
	}
	
	@RequestMapping("/okCheckBalance")
	public String okCheckBalance(Model model,@Valid CheckBalance account,BindingResult result) {

		if (result.hasErrors()) {
			return "checkBalance";
		}
		int balance=accountService.checkBalance(account);
		if (balance>=0) {
			model.addAttribute("balance", balance);
			return "checkBalanceOk";
		}
		model.addAttribute("error", "Invalid Account Number, UserName or Password");
			return "checkBalance";
		
	}
	@RequestMapping("/closeAccount")
	public String closeAcoount(Model model) {

		model.addAttribute(new CloseAccount());

		return "closeAcc";
	}
	
	@RequestMapping("/okClose")
	public String okCloseAccount(Model model,@Valid CloseAccount account,BindingResult result) {

		if (result.hasErrors()){	
			return "closeAcc";
		}
		if (accountService.closeAccount(account)) {
			return "closedAcc";
		}

		model.addAttribute("error", "Invalid Account Number, UserName or Password");
		return "closeAcc";
	}
	@RequestMapping("/withdrawMoney")
	public String withdrawMoney(Model model) {

		model.addAttribute(new WithdrawMoney());

		return "withdraw";
	}
	
	@RequestMapping("/okwithdraw")
	public String okWithdraw(Model model,@Valid WithdrawMoney account,BindingResult result) {

		if (result.hasErrors()) {
			return "withdraw";
		}
		if (accountService.withdrawMoney(account)) {
			Account acc	=accountService.showMyAccountDAO(account);
			model.addAttribute("myaccount", acc);
			return "withdrawOk";
		}
		model.addAttribute("error", "Invalid Account Number, UserName,Password or Money");
		return "withdraw";
		
	}
	
	@RequestMapping("/transferMoney")
	public String transferMoney(Model model) {

		model.addAttribute(new TransferMoney());

		return "transferMoney";
	}
	
	@RequestMapping("/oktransfer")
	public String transferMoney(Model model,@Valid TransferMoney account,BindingResult result) {

		if (result.hasErrors()) {
			return "transferMoney";
		}
		
		if (accountService.transferMoney(account)) {
			Account acc	=accountService.showMyAccountDAO(account);
			model.addAttribute("myaccount", acc);
			return "transferMoneyOk";
		}

		model.addAttribute("error", "Invalid Account Number, UserName,Password or Money");
		return "transferMoney";
		
	}
}
