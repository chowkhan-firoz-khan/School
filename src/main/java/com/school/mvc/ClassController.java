package com.school.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.repos.ClassRepository;

@Controller
public class ClassController {
	
	@Autowired
	private ClassRepository classRepository;
	
	@GetMapping("/classDetails")
	public ModelAndView showClassDetails(@RequestParam(name="classId") Long classId)
	{
		ModelAndView modelAndView  = new ModelAndView("class/classDetail");
		modelAndView.addObject("classDetail", classRepository.getOne(classId));	
		return modelAndView;
	}

}
