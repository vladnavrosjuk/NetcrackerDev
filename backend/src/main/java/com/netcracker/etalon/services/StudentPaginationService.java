package com.netcracker.etalon.services;

import com.netcracker.etalon.entities.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentPaginationService {
    List<StudentEntity> getPaginationAndSortedPageList(String search, String sort, String order, Integer offset, Integer limit);

}
