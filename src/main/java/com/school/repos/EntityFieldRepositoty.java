package com.school.repos;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.school.domain.EntityField;

public interface EntityFieldRepositoty extends PagingAndSortingRepository<EntityField,Long>
{

}
