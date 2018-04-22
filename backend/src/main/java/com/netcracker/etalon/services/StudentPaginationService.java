package com.netcracker.etalon.services;

import com.netcracker.etalon.entities.StudentEntity;

import java.util.List;

public interface StudentPaginationService {
    List<StudentEntity> getPaginationAndSortedPageList(String sort, String order, Integer offset, Integer limit);
}
