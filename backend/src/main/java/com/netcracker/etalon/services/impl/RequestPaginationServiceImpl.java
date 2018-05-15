package com.netcracker.etalon.services.impl;

import com.netcracker.etalon.entities.RequestEntity;
import com.netcracker.etalon.entities.StudentEntity;
import com.netcracker.etalon.repository.RequestPaginationRepository;
import com.netcracker.etalon.repository.StudentPaginationRepository;
import com.netcracker.etalon.services.RequestPaginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RequestPaginationServiceImpl implements RequestPaginationService {
    @Autowired
    RequestPaginationRepository requestPaginationRepository;
    @Override
    public List<RequestEntity> getPaginationAndSortedPageList(String search, String sort, String order, Integer offset, Integer limit) {
        int pageNumber = offset/limit;
        if (sort.equals("name"))
            sort = "namecompany";
        if (sort.equals("specialityName"))
            sort = "specialityEntity.name";
        if (sort.equals("studentsofpractice"))
            sort = "student.size";


        PageRequest pageRequest = new PageRequest(pageNumber,limit, Sort.Direction.fromString(order),sort);
        if (search!="")
            return requestPaginationRepository.searchbyname("%"+search+"%",pageRequest);
        return requestPaginationRepository.findAll(pageRequest).getContent();
    }
}
