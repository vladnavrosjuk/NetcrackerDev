package com.netcracker.etalon.converters;

import com.netcracker.etalon.entities.StudentEntity;
import com.netcracker.etalon.models.AssignViewModel;
import org.springframework.core.convert.converter.Converter;

public class StudentEntityToAssignViewModel implements Converter<StudentEntity,AssignViewModel> {
    @Override
    public AssignViewModel convert(StudentEntity studentEntity) {
        AssignViewModel assignViewModel =  new AssignViewModel();

        return null;
    }
}
