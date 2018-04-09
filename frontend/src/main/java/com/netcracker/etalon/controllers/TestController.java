package com.netcracker.etalon.controllers;



import com.netcracker.etalon.dto.AssignDto;
import com.netcracker.etalon.dto.RequestDto;
import com.netcracker.etalon.dto.SpecialityDto;
import com.netcracker.etalon.dto.StudentDTO;
import com.netcracker.etalon.entities.*;

import com.netcracker.etalon.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author anpi0316
 *         Date: 04.03.2018
 *         Time: 14:44
 */
@Controller

public class TestController {

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

    private static final String VIEW_NAME_LOGIN = "adminpage";
    private static final String VIEW_ALL_REQUEST = "request";



    @RequestMapping(value = "/autorization", method = RequestMethod.GET)
    public ModelAndView getAutorization() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("autorization");

        return modelAndView;
    }


    @RequestMapping(value = "/allrequest2", method = RequestMethod.GET)
    public ModelAndView getAllrequest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("request");

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
        FacultetEntity facultetEntity =  facultyService.findByid(requestDto.getFacultetid());
        requestEntity.setFacultetEntity(facultetEntity);
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
    }




    @RequestMapping(value = "/addAssign", method = RequestMethod.POST)
    @ResponseBody
    public void addAssign(@RequestBody AssignDto assignDto) {








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