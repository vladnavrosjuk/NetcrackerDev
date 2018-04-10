package com.netcracker.etalon.converters;

import com.netcracker.etalon.entities.FacultetEntity;
import com.netcracker.etalon.entities.SpecialityEntity;
import com.netcracker.etalon.models.FacultyViewModel;
import com.netcracker.etalon.models.SpecialityViewModel;
import com.netcracker.etalon.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class SpecialityEntityToSpecialityViewModel implements Converter<SpecialityEntity,SpecialityViewModel>{
    @Autowired
    ConversionService conversionService;
    @Autowired
    SpecialityService specialityService;

    @Override
    public SpecialityViewModel convert(SpecialityEntity specialityEntity) {
        SpecialityViewModel specialityViewModel = new SpecialityViewModel();
        specialityViewModel.setId(String.valueOf(specialityEntity.getId()));
        specialityViewModel.setName(specialityEntity.getName());
        specialityViewModel.setFacultyViewModel(conversionService.convert(specialityEntity.getFacultetEntity(), FacultyViewModel.class));
        return specialityViewModel;
    }
}
