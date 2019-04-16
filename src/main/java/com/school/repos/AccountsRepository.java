package com.school.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.school.domain.Account;

@RepositoryRestResource
public interface AccountsRepository extends JpaRepository<Account, Long>{

}
