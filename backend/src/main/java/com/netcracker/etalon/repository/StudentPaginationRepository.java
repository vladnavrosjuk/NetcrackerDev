package com.netcracker.etalon.repository;

import com.netcracker.etalon.entities.StudentEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentPaginationRepository extends PagingAndSortingRepository<StudentEntity, Integer> {

}
