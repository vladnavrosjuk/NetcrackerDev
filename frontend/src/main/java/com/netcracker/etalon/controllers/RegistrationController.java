package com.netcracker.etalon.controllers;

import com.netcracker.etalon.entities.RegistrationEntity;
import com.netcracker.etalon.entities.RequestEntity;
import com.netcracker.etalon.entities.StudentEntity;
import com.netcracker.etalon.entities.UserEntity;
import com.netcracker.etalon.models.StudentViewModel;
import com.netcracker.etalon.services.RegistrationService;
import com.netcracker.etalon.services.RequestService;
import com.netcracker.etalon.services.StudentService;
import com.netcracker.etalon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;
    @Autowired
    RequestService requestService;
    @Autowired
    StudentService studentService;
    @Autowired
    UserService userService;




    @RequestMapping(value = "/kel", method = RequestMethod.POST)
    @ResponseBody
    public void lel(@RequestBody StudentViewModel studentViewModel) {

        StudentEntity studentEntity = studentService.findById(Integer.valueOf(studentViewModel.getListid().get(0)));
        RegistrationEntity registrationEntity =  registrationService.findById(Integer.valueOf(studentViewModel.getIdStudent()) );
        UserEntity userEntity = new UserEntity();
        userEntity.setStudentEntity(studentEntity);
        userEntity.setLogin(registrationEntity.getLogin());
        userEntity.setPassuser(registrationEntity.getPassword());
        userEntity.setRole("ROLE_STUDENT");
        RequestEntity requestEntity = requestService.findById(14);
        userEntity.setRequestEntity(requestEntity);
        userService.add(userEntity);


        // return (List<RequestViewModel>) conversionService.convert(requestService.find(), requestEntityDescriptor, requestViewModelDescriptor);
    }
    @RequestMapping(value = "/addNewStudentInUser", method = RequestMethod.POST)
    @ResponseBody
    public void sd(@RequestBody StudentViewModel studentViewModel) {


        StudentEntity studentEntity = studentService.findById(Integer.valueOf(studentViewModel.getListid().get(0)));
        RegistrationEntity registrationEntity =  registrationService.findById(Integer.valueOf(studentViewModel.getIdStudent()) );
        UserEntity userEntity = new UserEntity();
        userEntity.setStudentEntity(studentEntity);
        userEntity.setLogin(registrationEntity.getLogin());
        userEntity.setPassuser(registrationEntity.getPassword());
        userEntity.setRole("ROLE_STUDENT");
        RequestEntity requestEntity = requestService.findById(14);
        userEntity.setRequestEntity(null);

        userService.add(userEntity);
        registrationService.deleteById(registrationEntity.getId());

        /*
        userService.add(userEntity);
*/

        // return (List<RequestViewModel>) conversionService.convert(requestService.find(), requestEntityDescriptor, requestViewModelDescriptor);
    }


    @RequestMapping(value = "/addNewRegistrationStudentReg", method = RequestMethod.POST)
    @ResponseBody
    public void addNewUser(@RequestBody StudentViewModel studentViewModel) {



        // return (List<RequestViewModel>) conversionService.convert(requestService.find(), requestEntityDescriptor, requestViewModelDescriptor);
    }
    @RequestMapping(value = "/addNewRegistration", method = RequestMethod.POST)
    @ResponseBody
    public void addNewRegistration(@RequestBody RegistrationEntity registrationEntity) {

            registrationService.addRegistration(registrationEntity);

        // return (List<RequestViewModel>) conversionService.convert(requestService.find(), requestEntityDescriptor, requestViewModelDescriptor);
    }

    @RequestMapping(value = "/setRegistrationStudentName", method = RequestMethod.POST)
    @ResponseBody
    public String addNewRegistration(@RequestBody StudentViewModel studentViewModel) {

        StudentEntity studentEntity = studentService.findById(Integer.valueOf(studentViewModel.getListid().get(0)));
        String name = studentEntity.getNamestud() + " " + studentEntity.getSurname();
        return name;

        // return (List<RequestViewModel>) conversionService.convert(requestService.find(), requestEntityDescriptor, requestViewModelDescriptor);
    }

    @RequestMapping(value = "/getRegistrationStudentDropwdon", method = RequestMethod.GET)
    @ResponseBody
    public List<RegistrationEntity> addNewDropdownStudent() {

        List<RegistrationEntity> registrationEntities = registrationService.findByRole("1");
        return registrationEntities;

        // return (List<RequestViewModel>) conversionService.convert(requestService.find(), requestEntityDescriptor, requestViewModelDescriptor);
    }



}
