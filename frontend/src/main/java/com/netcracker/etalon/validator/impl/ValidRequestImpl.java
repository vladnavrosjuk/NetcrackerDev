package com.netcracker.etalon.validator.impl;

import com.netcracker.etalon.entities.RequestEntity;
import com.netcracker.etalon.validator.ValidRequest;
import org.springframework.stereotype.Service;

import java.sql.Date;
@Service
public class ValidRequestImpl implements ValidRequest {
    @Override
    public Boolean validRequest(RequestEntity requestEntity) {
        if (requestEntity.getQuantity()!=null&&
                requestEntity.getDatefinish()!=null&&
                requestEntity.getDatestart()!=null&&
                requestEntity.getNamecompany()!=null&&
                requestEntity.getMinavscore()!=null)
        {
            if (String.valueOf(requestEntity.getDatestart()).matches("[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}")&&
                    String.valueOf(requestEntity.getDatefinish()).matches("[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}")&&
                    requestEntity.getNamecompany().matches("([A-Z])\\w+")&&
                    String.valueOf(requestEntity.getQuantity()).matches("\\d{1,2}|100")&&
                    String.valueOf(requestEntity.getMinavscore()).matches("([0-9]{1}[.]{1}[0-9]{1,2})|10"))
                return true;
            else
                return false;
        }
        else return false;

    }
}
