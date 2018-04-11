package com.netcracker.etalon.converters;

import com.netcracker.etalon.entities.FacultetEntity;
import com.netcracker.etalon.entities.SpecialityEntity;
import com.netcracker.etalon.entities.StudentEntity;
import com.netcracker.etalon.models.AssignViewModel;
import com.netcracker.etalon.models.StudentViewModel;
import com.netcracker.etalon.services.FacultyService;
import com.netcracker.etalon.services.RequestService;
import com.netcracker.etalon.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class StudentEntityToStudentViewModel implements Converter<StudentEntity,StudentViewModel> {
    @Autowired
    private ConversionService conversionService;
    @Autowired
    SpecialityService specialityService;
    @Autowired
    private FacultyService facultyService;



    @Override
    public StudentViewModel convert(StudentEntity studentEntity) {
        StudentViewModel studentViewModel = new StudentViewModel();
        studentViewModel.setAvscore(String.valueOf(studentEntity.getAvscore()));

        studentViewModel.setGroupstud(String.valueOf(studentEntity.getGroupstud()));
        studentViewModel.setIdStudent(String.valueOf(studentEntity.getId()));
        studentViewModel.setNamestud(studentEntity.getNamestud());
        studentViewModel.setSurname(studentEntity.getSurname());
       SpecialityEntity specialityEntity = studentEntity.getSpecialityEntity();
        studentViewModel.setSpeciality(specialityEntity.getName());
        studentViewModel.setSpecialityId(String.valueOf(specialityEntity.getId()));


        FacultetEntity facultyEntity = specialityEntity.getFacultetEntity();
        studentViewModel.setFacultet(facultyEntity.getName());
        studentViewModel.setFacultetid(String.valueOf(facultyEntity.getId()));
        studentViewModel.setBudjet(studentEntity.getBudjet());/*

        if (studentEntity.getStatusstud() == 1 )
            studentViewModel.setStatusstud("Raspred");
        else    studentViewModel.setStatusstud("NeRaspred");*/


        return studentViewModel;
    }
}
