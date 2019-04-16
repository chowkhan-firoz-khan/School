package com.school.rest;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.school.domain.EntityFieldType;

@RestController
public class CommonConfigController {
	
	@GetMapping(value="/getFieldTypes")
	public HttpEntity<EntityFieldType[]> getAllFieldTypes()
	{
		return new HttpEntity<EntityFieldType[]>(EntityFieldType.values());
	}
}
