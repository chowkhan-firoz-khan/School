package com.school.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.domain.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole, Long>{

}
