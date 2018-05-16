package com.netcracker.etalon.validator.impl;

import com.netcracker.etalon.entities.StudentEntity;
import com.netcracker.etalon.validator.ValidStudent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;




@Service
public class ValidStudentImpl implements ValidStudent {
    public Boolean validStudent(StudentEntity studentEntity)
    {
        Pattern p = Pattern.compile("([0-9]{1}[.]{1}[0-9]{1,2})|10");
        Matcher m = p.matcher("11");
        System.out.println(m.matches());

        if (studentEntity.getAvscore()!=null&&
                studentEntity.getSurname()!=null&&
                studentEntity.getNamestud()!=null&&
                studentEntity.getGroupstud()!=null&&
                studentEntity.getBudjet()!=null
                ){
        if      (

                studentEntity.getNamestud().matches("[A-Z]{1}[a-z]+")&&
                studentEntity.getSurname().matches("[A-Z]{1}[a-z]+")&&
                String.valueOf(studentEntity.getAvscore()).matches("([0-9]{1}[.]{1}[0-9]{1,2})|10")&&
                String.valueOf(studentEntity.getGroupstud()).matches("[0-9]+")


                )
            return true;

        else return false;}
        else return false;

    }
}
