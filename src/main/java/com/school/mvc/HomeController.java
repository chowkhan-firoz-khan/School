package com.school.mvc;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.domain.EntityFieldType;
import com.school.repos.UserRepository;

@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public String showHomeScreen() {

		return "index";
	}

	@PostMapping("/login")
	public String  login(@RequestParam(name="login") String login,@RequestParam(name="pwd") String pwd) 
	{
		if(StringUtils.isBlank(login) || StringUtils.isBlank(pwd))
		{
			return "redirect:/index";
		}
		else if(userRepository.)
		{
			
		}
		return "home";
	}

}
