package com.school.mvc;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.domain.Account;
import com.school.domain.Branch;
import com.school.repos.AccountsRepository;
import com.school.repos.BranchRepo;
import com.school.repos.ClassRepository;
import com.school.vo.BranchVo;
import com.school.vo.ClassVo;

@Controller
public class BranchController 
{
	@Autowired
	private BranchRepo branchrepository;
	
	@Autowired
	private ClassRepository classrepository;
	
	@Autowired
	private AccountsRepository accountsRepository;
	
	@GetMapping(value="/branches")
	public ModelAndView getAllBranches(@RequestParam(required=true,name="accountId") Long accountId)
	{
		Account account =  accountsRepository.getOne(accountId);
		ModelAndView view  = new ModelAndView("branch/branches");
		List<Branch> branches = Collections.emptyList();
		if(account !=null)
		{
			branches = branchrepository.findBranchesByAccountId(accountId);
		}
		view.addObject("branches",branches);
		return view;
	}
	
	
	@GetMapping(value="/newBranch")
	public String newBranchDetail(@RequestParam(required=true,name="accountId") Long accountId,@ModelAttribute(name="branch") BranchVo branch)
	{
		Account account  = accountsRepository.getOne(accountId);
		branch.setAccount(account);
		return  "branch/newBranch";
	}
	
	@PostMapping(value="/saveBranch")
	public String saveBranch(@ModelAttribute(name="branch") BranchVo branch,@RequestParam(name="accountId") Long accountId)
	{
		Account account  = accountsRepository.getOne(accountId);
		if(account !=null)
		{
			branch.setAccount(account);
			if(branch.performValidation().size() >0)
			{
				return  "branch/newBranch";
			}	
			try
			{
				branchrepository.save(branch.getBranchEntity());
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return "redirect:/branches?accountId="+accountId;
	}
	
	@GetMapping(value="/branchInfo")
	public ModelAndView getBranchInfo(@RequestParam(name="id") Long branchId)
	{
		ModelAndView modelAndView  = new ModelAndView("branch/branchDetail");
		Branch branch = branchrepository.getOne(branchId);
		modelAndView.addObject("classes",classrepository.findAllClassesByBranch(branchId));
		modelAndView.addObject("branch", branch);
		return modelAndView;
	}
	
	@GetMapping(value="/createClass")
	public String showClassForm(@ModelAttribute(name="class") ClassVo classVo,@RequestParam(name="branch") Long branchId)
	{
		classVo.setBranchId(branchId);
		return "class/newClass";
	}
	
	@PostMapping(value="/saveClass")
	public String saveClass(@ModelAttribute(name="class") ClassVo classVo,@RequestParam(name="branchId") Long branchId)
	{
		classVo.setBranchId(branchId);
		Branch branch = branchrepository.getOne(branchId);
		classVo.setBranch(branch);
		classVo.performValidation();
		if(classVo.getValidationErrors().size() > 0)
		{
			return "class/newClass";
		}
		try
		{
			classrepository.save(classVo.getEntity());
		}
		catch(Exception e)
		{
			classVo.setValidationErrors(e.getMessage());
			return "class/newClass";
		}
		return "redirect:/branchInfo?id="+branchId;
	}
	
	
}
