package com.school.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.school.domain.User;

public interface UserRepository extends JpaRepository<User,Long> 
{
	@Query(value="select u from  User u where u.userId=:login and u.password=:pwd")
	public User getUserByLoginAndPwd(String login,String pwd);
}
