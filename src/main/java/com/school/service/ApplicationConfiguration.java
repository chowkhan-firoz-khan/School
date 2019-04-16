package com.school.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.school.domain.UserRole;
import com.school.repos.UserRoleRepo;

@Service
public class ApplicationConfiguration implements InitializingBean 
{
	@Value("${school.available.roles}")
	private String availableRoles;
	
	public String getAvailableRoles() {
		return availableRoles;
	}

	public void setAvailableRoles(String availableRoles) {
		this.availableRoles = availableRoles;
	}

	public UserRoleRepo getUserRoleRepo() {
		return userRoleRepo;
	}

	public void setUserRoleRepo(UserRoleRepo userRoleRepo) {
		this.userRoleRepo = userRoleRepo;
	}

	@Autowired
	private UserRoleRepo userRoleRepo;

	private Map<String, UserRole> map = new HashMap<>();

	private void refreshUserRoles() {
		this.userRoleRepo.findAll().forEach((UserRole userRole) -> {
			map.put(userRole.getRole(), userRole);
		});
	}

	public UserRole getRole(String role) {
		return map.containsKey(role) ? map.get(role) : null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(!StringUtils.isEmpty(availableRoles))
		{
			String[] roles = availableRoles.split(",");
			Set<UserRole> userRoles  = new HashSet<>();
			for(String role :roles)
			{
				UserRole userRole = new UserRole(role, role);
				userRoles.add(userRole);
				map.put(role, userRole);
			}
			try
			{
				userRoleRepo.saveAll(userRoles);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		this.refreshUserRoles();
	}
}
