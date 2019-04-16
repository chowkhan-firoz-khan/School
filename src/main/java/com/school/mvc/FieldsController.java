package com.school.mvc;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.domain.EntityField;
import com.school.domain.EntityFieldType;
import com.school.repos.EntityFieldRepositoty;
import com.school.vo.EntityFieldVo;

@Controller
public class FieldsController {

	@Autowired
	private EntityFieldRepositoty entityFieldRepository;

	@GetMapping(value = "/fields")
	public ModelAndView getFields() {
		ModelAndView view = new ModelAndView("fields/fields");
		view.addObject("fields", entityFieldRepository.findAll());
		return view;
	}

	@GetMapping(value = "/newField")
	public String newField(@ModelAttribute("field") EntityFieldVo field) 
	{
		field.setAction("/saveField");
		field.setMethod("post");
		field.setValidations(Collections.emptyList());
		field.setFieldTypes(EntityFieldType.values());
		return "fields/fieldEdit";
	}

	@GetMapping(value = "/showFieldDetail")
	public String showFieldInfo(@RequestParam(required = true, name = "id") Long id,@ModelAttribute("field") EntityFieldVo field) {
		
		field.setAction("/updateField");
		field.setMethod("put");
		field.fromEntity(entityFieldRepository.findById(id).get());
		field.setValidations(Collections.emptyList());
		return "fields/fieldEdit";
	}

	@PostMapping(value = "/saveField")
	public String saveField(@ModelAttribute("field") EntityFieldVo field, BindingResult result)
	{
		field.performValidations();
		if(!field.getValidations().isEmpty())
		{
			return "fields/fieldEdit";
		}
		entityFieldRepository.save(field.toEntity());
		return "redirect:/fields";
	}
	
	@PutMapping(value = "/updateField")
	public String updateField(@ModelAttribute("field") EntityFieldVo field)
	{
		field.performValidations();
		if(!field.getValidations().isEmpty())
		{
			return "fields/fieldEdit";
		}
		entityFieldRepository.save(field.toEntity());
		return "redirect:/fields";
	}

	public EntityFieldRepositoty getEntityFieldRepository() {
		return entityFieldRepository;
	}

	public void setEntityFieldRepository(EntityFieldRepositoty entityFieldRepository) {
		this.entityFieldRepository = entityFieldRepository;
	}
}
