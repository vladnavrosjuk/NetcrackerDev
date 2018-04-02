/*
        This software is the confidential information and copyrighted work of
        NetCracker Technology Corp. ("NetCracker") and/or its suppliers and
        is only distributed under the terms of a separate license agreement
        with NetCracker.
        Use of the software is governed by the terms of the license agreement.
        Any use of this software not in accordance with the license agreement
        is expressly prohibited by law, and may result in severe civil
        and criminal penalties.

        Copyright (c) 1995-2017 NetCracker Technology Corp.

        All Rights Reserved.

        */
/*
 * Copyright 1995-2017 by NetCracker Technology Corp.,
 * University Office Park III
 * 95 Sawyer Road
 * Waltham, MA 02453
 * United States of America
 * All rights reserved.
 */
package com.netcracker.etalon.controllers;



import com.netcracker.etalon.dto.SpecialityDto;
import com.netcracker.etalon.entities.*;
import com.netcracker.etalon.models.UserViewModel;
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
import java.util.List;

/**
 * @author anpi0316
 *         Date: 04.03.2018
 *         Time: 14:44
 */
@Controller

public class TestController {


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

    private List<UserViewModel> userViewModels = new ArrayList<>();




  /*  @RequestMapping(value = "/allrequest", method = RequestMethod.GET)
    public ModelAndView getAllRequest(ModelMap modelMap) {
        modelMap.addAttribute("request", new Facultet());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VIEW_ALL_REQUEST);
        return modelAndView;
    }*/
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



    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public void getUsersAsJson(@RequestBody SpecialityEntity specialityEntity) {
        /*    SpecialityEntity specialityEntity = specialityService.find("kek");
            StudentEntity studentEntity1 = new StudentEntity();
       studentEntity1.setNamestud("test");
        studentEntity1.setSurname("test");
        studentEntity1.setAvscore(9.0);
        studentEntity1.setBudjet("test");
        studentEntity1.setGroupstud(521701);
        studentEntity1.setSpecialityEntity(specialityEntity);
        studentEntity1.setStatusstud(1);
        studentService.addStudent(studentEntity1);*/



     /*
        StudentEntity studentEntity1  = studentService.find("test");
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin("test");
        userEntity.setPassuser("test");
        userEntity.setStudentEntity(studentEntity1);
        userService.add(userEntity);*/

        specialityService.addspeciality(specialityEntity);




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

    @RequestMapping(value = "/dropDown2", method = RequestMethod.POST)
    @ResponseBody
    public List<SpecialityEntity> dropdown2(@RequestBody SpecialityDto specialityDto) {
            FacultetEntity facultetEntity = facultyService.findByid(specialityDto.getFacultetId());
      return specialityService.findByFacultetEntity(facultetEntity);



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