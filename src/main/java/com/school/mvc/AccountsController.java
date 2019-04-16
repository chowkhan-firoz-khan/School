package com.school.mvc;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.school.domain.Account;
import com.school.repos.AccountsRepository;
import com.school.repos.BranchRepo;

@Controller
public class AccountsController 
{
	@Autowired
	private AccountsRepository accountsRepo;
	
	@Autowired
	private BranchRepo branchRepository;
	
	
	@GetMapping(value="/accounts")
	public ModelAndView getAllAccounts()
	{
		ModelAndView modelAndView  = new ModelAndView("accounts");
		modelAndView.addObject("accounts", accountsRepo.findAll());
		return modelAndView;
	}
	
	@GetMapping(value="/newAccount")
	public String getNewAccountScreen()
	{
		return "newAccount";
	}
	
	@PostMapping(value="/saveAccount")
	@ResponseStatus(value=HttpStatus.OK)
	public String saveAccount(@ModelAttribute("account") Account account)
	{
		this.accountsRepo.save(account);
		return "redirect:/accounts";
	}
	
	@GetMapping(value="/accountDetails")
	public ModelAndView getAccountDetails(@RequestParam(name="id",required=true) Long id)
	{
		ModelAndView modelAndView  = new ModelAndView("accountDetail");
		modelAndView.addObject("account", accountsRepo.getOne(id));
		modelAndView.addObject("branches",this.branchRepository.findBranchesByAccountId(id));
		return modelAndView;
	}
}
