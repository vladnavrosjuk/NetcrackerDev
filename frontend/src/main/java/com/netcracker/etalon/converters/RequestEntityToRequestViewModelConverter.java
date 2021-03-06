package com.netcracker.etalon.converters;

import com.netcracker.etalon.entities.FacultetEntity;
import com.netcracker.etalon.entities.RequestEntity;
import com.netcracker.etalon.entities.SpecialityEntity;
import com.netcracker.etalon.models.RequestViewModel;
import com.netcracker.etalon.models.SpecialityViewModel;
import com.netcracker.etalon.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class RequestEntityToRequestViewModelConverter implements Converter<RequestEntity,RequestViewModel> {

    @Autowired
    private ConversionService conversionService;
    @Autowired
    private RequestService requestService;



    @Override
    public RequestViewModel convert(RequestEntity requestEntity) {
        RequestViewModel requestViewModel = new RequestViewModel();
        requestViewModel.setMinavscore(String.valueOf(requestEntity.getMinavscore()));
        requestViewModel.setQuantity(String.valueOf(requestEntity.getQuantity()));
        requestViewModel.setIdRequest(String.valueOf(requestEntity.getId()));
        requestViewModel.setName(requestEntity.getNamecompany());
        SpecialityEntity specialityEntity = requestEntity.getSpecialityEntity();
        requestViewModel.setIdSpeciality(String.valueOf(specialityEntity.getId()));
        requestViewModel.setSpecialityName(specialityEntity.getName());
        requestViewModel.setDatefinish(String.valueOf(requestEntity.getDatefinish()));
        requestViewModel.setDatestart(String.valueOf(requestEntity.getDatestart()));
        requestViewModel.setStudentsofpractice(String.valueOf(requestEntity.getStudent().size()));
/*        SpecialityEntity specialityEntity = requestService.findById(requestEntity.getId()).getSpecialityEntity();
        String name = specialityEntity.getName();*/

        return requestViewModel;
    }
}
