package com.netcracker.etalon.repository;

import com.netcracker.etalon.entities.RequestEntity;
import com.netcracker.etalon.entities.StudentEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestPaginationRepository extends PagingAndSortingRepository<RequestEntity, Integer> {

    @Query(value = "SELECT * FROM request WHERE  request.namecompany LIKE :namecompany \n#pageable\n", nativeQuery = true)
    List<RequestEntity> searchbyname(@Param("namecompany") String score, Pageable pageable);
}
