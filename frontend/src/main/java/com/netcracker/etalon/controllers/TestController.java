package com.netcracker.etalon.controllers;


import com.netcracker.etalon.dto.AssignDto;
import com.netcracker.etalon.dto.RequestDto;
import com.netcracker.etalon.dto.SpecialityDto;
import com.netcracker.etalon.dto.StudentDTO;
import com.netcracker.etalon.entities.FacultetEntity;
import com.netcracker.etalon.entities.RequestEntity;
import com.netcracker.etalon.entities.SpecialityEntity;
import com.netcracker.etalon.entities.StudentEntity;
import com.netcracker.etalon.models.RequestViewModel;
import com.netcracker.etalon.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller

public class TestController {


    @Autowired
    ConversionService conversionService;
    @Autowired
    private RequestService requestService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    private  final TypeDescriptor requestEntityDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RequestEntity.class));
    private  final TypeDescriptor requestViewModelDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RequestViewModel.class));

    private static final String VIEW_NAME_LOGIN = "adminpage";
    private static final String VIEW_ALL_REQUEST = "request";


    @RequestMapping(value = "/autorization", method = RequestMethod.GET)
    public ModelAndView getAutorization() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("autorization");//constants

        return modelAndView;
    }


    @RequestMapping(value = "/allrequest2", method = RequestMethod.GET)//?
    public ModelAndView getAllrequest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("request");//constants

        return modelAndView;
    }


    @RequestMapping(value = "/infostudent", method = RequestMethod.GET)
    public ModelAndView getInfoStudent(ModelMap modelMap) {


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("informstudent");
        return modelAndView;
    }


    @RequestMapping(value = "/admin-page", method = RequestMethod.GET)
    public ModelAndView getAdminPage(ModelMap modelMap) {


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VIEW_NAME_LOGIN);

        return modelAndView;
    }

    @RequestMapping(value = "/dropdown", method = RequestMethod.GET)
    @ResponseBody
    public List<FacultetEntity> getAdminPage() {

        return facultyService.findall();
    }


    @RequestMapping(value = "/dropdownRequest", method = RequestMethod.GET)
    @ResponseBody
    public List<RequestEntity> getAllRequest() {

        return requestService.find();
    }


    @RequestMapping(value = "/dropdownStudent", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentEntity> getStudent() {

        return studentService.findall();
    }


    @RequestMapping(value = "/dropdownSpeciality", method = RequestMethod.GET)
    @ResponseBody
    public List<SpecialityEntity> getSpeciality() {

        return specialityService.findall();
    }


    @RequestMapping(value = "/addFacultet", method = RequestMethod.POST)
    @ResponseBody
    public void addFacultet(@RequestBody FacultetEntity facultetEntity) {

        facultyService.addFaculty(facultetEntity);


    }


    @RequestMapping(value = "/addSpeciality", method = RequestMethod.POST)
    @ResponseBody
    public void addSpeciality(@RequestBody SpecialityDto specialityDto) {

        FacultetEntity facultetEntity = facultyService.findByid(specialityDto.getFacultetId());
        SpecialityEntity specialityEntity = new SpecialityEntity();
        specialityEntity.setName(specialityDto.getName());
        specialityEntity.setFacultetEntity(facultetEntity);
        specialityService.addspeciality(specialityEntity);


    }

    @RequestMapping(value = "/specialityfor1", method = RequestMethod.GET)
    @ResponseBody
    public List<SpecialityEntity> specialityfor1add() {
        FacultetEntity facultetEntity = facultyService.findByid(1);
        return specialityService.findByFacultetEntity(facultetEntity);


    }

    @RequestMapping(value = "/dropDown2", method = RequestMethod.POST)
    @ResponseBody
    public List<SpecialityEntity> dropdown2(@RequestBody SpecialityDto specialityDto) {
        FacultetEntity facultetEntity = facultyService.findByid(specialityDto.getFacultetId());
        return specialityService.findByFacultetEntity(facultetEntity);


    }


    @RequestMapping(value = "/addRequest", method = RequestMethod.POST)
    @ResponseBody
    public void addRequest(@RequestBody RequestDto requestDto) {
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setNamecompany(requestDto.getNamecompany());
        SpecialityEntity specialitentity = specialityService.findById(requestDto.getFacultetid());
        requestEntity.setSpecialityEntity(specialitentity);
        requestEntity.setDatestart(requestDto.getDatestart());
        requestEntity.setDatefinish(requestDto.getDatefinish());
        requestEntity.setMinavscore(requestDto.getMinavscore());
        requestEntity.setQuantity(requestDto.getQuantity());
        requestService.addRequest(requestEntity);
    }


    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    @ResponseBody
    public void addStudent(@RequestBody StudentDTO studentDTO) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setGroupstud(studentDTO.getGroupstud());
        studentEntity.setNamestud(studentDTO.getNamestud());
        studentEntity.setSpecialityEntity(specialityService.findById(studentDTO.getSpecialityid()));
        studentEntity.setSurname(studentDTO.getSurname());
        studentEntity.setBudjet(studentDTO.getBudjet());
        studentEntity.setAvscore(studentDTO.getAvscore());
        studentService.addStudent(studentEntity);
        List<StudentEntity> studentEntities = studentService.findbyquantityandfacultet(4.0, 1);
        System.out.println();
        RequestEntity requestEntity = requestService.findById(16);
        StudentEntity studentEntity1 = studentService.findById(7);
        requestEntity.getStudent().add(studentEntity1);
        requestService.addRequest(requestEntity);
    }




    @RequestMapping(value = "/multiselectForRequest", method = RequestMethod.POST)
    @ResponseBody
    public List<StudentEntity> addAssign(@RequestBody RequestDto requestDto) {
        RequestEntity requestEntity = requestService.findById(requestDto.getId());
        Double score = requestEntity.getMinavscore();
        SpecialityEntity specialityEntity = requestEntity.getSpecialityEntity();
        Integer id = specialityEntity.getId();
        return studentService.findbyquantityandfacultet(score, id);
    }


    @RequestMapping(value = "/ogr", method = RequestMethod.POST)
    @ResponseBody
    public RequestEntity findrequest(@RequestBody RequestDto requestDto) {
        RequestEntity requestEntity = requestService.findById(requestDto.getId());

        return requestEntity;
    }


    @RequestMapping(value = "/addAssign", method = RequestMethod.POST)
    @ResponseBody
    public void addAssign(@RequestBody AssignDto assignDto) {
        RequestEntity requestEntity = requestService.findById(assignDto.getRequestId());
        Integer quantity = requestEntity.getQuantity();
        int countofstudents = 0;
        for(Integer id:assignDto.getStudents())

        {
            countofstudents++;
            StudentEntity studentEntity = studentService.findById(id);
            studentEntity.setStatusstud(1);
            requestEntity.getStudent().add(studentEntity);
        }
        quantity = quantity - countofstudents;
            if (quantity>=0) {
                requestEntity.setQuantity(quantity);
                requestService.addRequest(requestEntity);
            }




    }




    @RequestMapping(value = "/requestForTable", method = RequestMethod.GET)
    @ResponseBody
    public List<RequestViewModel> getAllStudents() {
        List<RequestEntity> allrequest = requestService.find();
        return (List<RequestViewModel>) conversionService.convert(allrequest, requestEntityDescriptor, requestViewModelDescriptor);
    }


}
/*
 WITHOUT LIMITING THE FOREGOING, COPYING, REPRODUCTION, REDISTRIBUTION,
 REVERSE ENGINEERING, DISASSEMBLY, DECOMPILATION OR MODIFICATION
 OF THE SOFTWARE IS EXPRESSLY PROHIBITED, UNLESS SUCH COPYING,
 REPRODUCTION, REDISTRIBUTION, REVERSE ENGINEERING, DISASSEMBLY,
 DECOMPILATION OR MODIFICATION IS EXPRESSLY PERMITTED BY THE LICENSE
 AGREEMENT WITH NETCRACKER.
 THIS SOFTWARE IS WARRANTED, IF AT ALL, ONLY AS EXPRESSLY PROVIDED IN
 THE TERMS OF THE LICENSE AGREEMENT, EXCEPT AS WARRANTED IN THE
 LICENSE AGREEMENT, NETCRACKER HEREBY DISCLAIMS ALL WARRANTIES AND
 CONDITIONS WITH REGARD TO THE SOFTWARE, WHETHER EXPRESS, IMPLIED
 OR STATUTORY, INCLUDING WITHOUT LIMITATION ALL WARRANTIES AND
 CONDITIONS OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE,
 TITLE AND NON-INFRINGEMENT.
 Copyright (c) 1995-2017 NetCracker Technology Corp.
 All Rights Reserved.
*/