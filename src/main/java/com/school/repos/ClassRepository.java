package com.school.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.school.domain.ClassTo;

public interface ClassRepository extends JpaRepository<ClassTo, Long>{
	
	@Query(value="select c from class c where c.branch.id=?1")
	public List<ClassTo> findAllClassesByBranch(Long branchId);

}
