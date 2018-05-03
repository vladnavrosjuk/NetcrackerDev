package com.netcracker.etalon.repository;

import com.netcracker.etalon.entities.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentPaginationRepository extends PagingAndSortingRepository<StudentEntity, Integer>  {

    @Query (value = "SELECT * FROM student WHERE  student.namestud LIKE :namestudena", nativeQuery = true)
    List<StudentEntity> searchbyname(@Param("namestudena") String score);




}
