package com.netcracker.etalon.services.impl;

import com.netcracker.etalon.entities.StudentEntity;
import com.netcracker.etalon.repository.StudentPaginationRepository;
import com.netcracker.etalon.services.StudentPaginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service

public class StudentPaginationServiceImpl implements StudentPaginationService {
    @Autowired
    StudentPaginationRepository studentPaginationRepository;
    @Override
    public List<StudentEntity> getPaginationAndSortedPageList(String search,String sort, String order, Integer offset, Integer limit) {
        int pageNumber = offset/limit;
        if (sort.equals("speciality"))
            sort = "specialityEntity.name";
        if (sort.equals("facultet"))
            sort = "specialityEntity.FacultetEntity.name";
        PageRequest pageRequest = new PageRequest(pageNumber,limit, Sort.Direction.fromString(order),sort);
        if (search!="")
            return studentPaginationRepository.searchbyname("%"+search+"%",pageRequest);
        return studentPaginationRepository.findAll(pageRequest).getContent();
    }

}
