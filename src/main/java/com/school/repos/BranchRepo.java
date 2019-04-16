package com.school.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.school.domain.Branch;

public interface BranchRepo extends JpaRepository<Branch,Long> 
{
	@Query(value="SELECT b from branch b where b.account.id=?1")
	public List<Branch> findBranchesByAccountId(Long accountId);
}
