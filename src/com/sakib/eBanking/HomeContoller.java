package com.sakib.eBanking;

import java.util.List;
import java.util.Map;

import javax.management.loading.PrivateClassLoader;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sakib.eBanking.DAO.Account;
import com.sakib.eBanking.DAO.AccountDAO;
import com.sakib.eBanking.Service.AccountService;

@Controller
public class HomeContoller {

	@RequestMapping("/")
	public String showHome() {
		
		return "home";
	}
}
