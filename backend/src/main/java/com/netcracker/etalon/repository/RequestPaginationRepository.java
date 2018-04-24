package com.netcracker.etalon.repository;

import com.netcracker.etalon.entities.RequestEntity;
import com.netcracker.etalon.entities.StudentEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RequestPaginationRepository extends PagingAndSortingRepository<RequestEntity, Integer> {
}
