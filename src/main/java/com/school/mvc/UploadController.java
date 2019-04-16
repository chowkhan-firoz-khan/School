package com.school.mvc;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.school.domain.Account;
import com.school.domain.ClassTo;
import com.school.repos.AccountsRepository;
import com.school.repos.ClassRepository;
import com.school.service.UserService;

@Controller
public class UploadController 
{
	@Value("${schools.file.upload.dir}")
	private String fileUploadPath;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountsRepository accountRepositiory;
	
	@Autowired
	private ClassRepository classrepository;
	
	@PostMapping("/uploadUser")
	public ModelAndView uploadUsers(@RequestParam(required=true,value="uploadUsers") MultipartFile file,@RequestParam(required=true,value="classid") Long classId) throws IllegalStateException, IOException
	{
		File uploadedFile  = userService.uploadFile(file, fileUploadPath);
		ClassTo classTo  = classrepository.getOne(classId);
		ModelAndView modelAndView = new ModelAndView("upload/class/summary");
		modelAndView.addObject("errors",userService.validateAndSaveUsereData(uploadedFile, classTo));
		modelAndView.addObject("class", classTo);
		return modelAndView;
	}
	
	@PostMapping("/uploadAttendnace")
	public ModelAndView uploadUserAttendance(@RequestParam(required=true,value="uploadAttendance") MultipartFile file,@RequestParam(required=true,value="classid") Long classId) throws IllegalStateException, IOException
	{
		File uploadedFile  = userService.uploadFile(file, fileUploadPath);
		ClassTo classTo  = classrepository.getOne(classId);
		ModelAndView modelAndView = new ModelAndView("upload/class/summary");
		modelAndView.addObject("errors",userService.validateAndSaveUserAttendanceeData(uploadedFile, classTo));
		modelAndView.addObject("class", classTo);
		return modelAndView;
	}

}
	