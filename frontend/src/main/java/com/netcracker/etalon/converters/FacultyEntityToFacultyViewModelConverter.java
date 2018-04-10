package com.netcracker.etalon.converters;

import com.netcracker.etalon.entities.FacultetEntity;
import com.netcracker.etalon.models.FacultyViewModel;
import org.springframework.core.convert.converter.Converter;

public class FacultyEntityToFacultyViewModelConverter implements Converter<FacultetEntity,FacultyViewModel> {

    @Override
    public FacultyViewModel convert(FacultetEntity facultetEntity) {
        FacultyViewModel facultyViewModel = new FacultyViewModel();
        facultyViewModel.setName(facultetEntity.getName());
        facultyViewModel.setId(String.valueOf(facultetEntity.getId()));
        return facultyViewModel;
    }
}
