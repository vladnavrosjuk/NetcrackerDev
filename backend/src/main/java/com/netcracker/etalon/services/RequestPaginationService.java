package com.netcracker.etalon.services;

import com.netcracker.etalon.entities.RequestEntity;
import com.netcracker.etalon.entities.StudentEntity;

import java.util.List;

public interface RequestPaginationService {
    List<RequestEntity> getPaginationAndSortedPageList(String search, String sort, String order, Integer offset, Integer limit);
}
