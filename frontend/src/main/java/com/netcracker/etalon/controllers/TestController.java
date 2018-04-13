package com.netcracker.etalon.controllers;


import com.netcracker.etalon.dto.*;
import com.netcracker.etalon.entities.FacultetEntity;
import com.netcracker.etalon.entities.RequestEntity;
import com.netcracker.etalon.entities.SpecialityEntity;
import com.netcracker.etalon.entities.StudentEntity;
import com.netcracker.etalon.models.RequestViewModel;
import com.netcracker.etalon.models.StudentViewModel;
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

import java.util.ArrayList;
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


    private  final TypeDescriptor studentEntityDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentEntity.class));
    private  final TypeDescriptor studentViewModelDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentViewModel.class));

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
    public List<StudentViewModel> addStudent(@RequestBody StudentDTO studentDTO) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setGroupstud(studentDTO.getGroupstud());
        studentEntity.setNamestud(studentDTO.getNamestud());
        studentEntity.setSpecialityEntity(specialityService.findById(studentDTO.getSpecialityid()));
        studentEntity.setSurname(studentDTO.getSurname());
        studentEntity.setBudjet(studentDTO.getBudjet());
        studentEntity.setAvscore(studentDTO.getAvscore());
        studentEntity.setStatusstud("NeRaspredeln");

        studentService.addStudent(studentEntity);
        StudentEntity studentEntitymax = studentService.findById(studentService.maxId());

        List<StudentEntity> studentEntityList =  new ArrayList<>();
        studentEntityList.add(studentEntitymax);
        return  (List<StudentViewModel>) conversionService.convert(studentEntityList, studentEntityDescriptor, studentViewModelDescriptor);



    }




    @RequestMapping(value = "/multiselectForRequest", method = RequestMethod.POST)
    @ResponseBody
    public List<StudentEntity> addAssign(@RequestBody RequestDto requestDto) {
        RequestEntity requestEntity = requestService.findById(requestDto.getId());
        Double score = requestEntity.getMinavscore();
        SpecialityEntity specialityEntity = requestEntity.getSpecialityEntity();
        Integer id = specialityEntity.getId();
        List<StudentEntity> students = requestEntity.getStudent();
        List<StudentEntity> studentsfotrequest = studentService.findbyquantityandfacultet(score, id);
        for (StudentEntity studentEntity:students){
            studentsfotrequest.remove(studentEntity);

        }


        return studentsfotrequest;
    }


    @RequestMapping(value = "/ogr", method = RequestMethod.POST)
    @ResponseBody
    public RequestEntity findrequest(@RequestBody RequestDto requestDto) {
        RequestEntity requestEntity = requestService.findById(requestDto.getId());

        return requestEntity;
    }
    @RequestMapping(value = "/testel", method = RequestMethod.POST)
    @ResponseBody
    public void asd(@RequestBody StudentViewModel studentViewModel) {
        List<String> list = studentViewModel.getListid();
        for (String id : list){
            StudentEntity studentEntity = studentService.findById(Integer.valueOf(id));
            for (RequestEntity requestEntity:studentEntity.getRequest())
            {
                requestEntity.getStudent().remove(studentEntity);
                Integer quantuty = requestEntity.getQuantity();
                quantuty++;
                requestEntity.setQuantity(quantuty);
                requestService.addRequest(requestEntity);
            }
            studentService.deleteById(Integer.valueOf(id));
        }

        System.out.println();

       // return (List<RequestViewModel>) conversionService.convert(requestService.find(), requestEntityDescriptor, requestViewModelDescriptor);
    }




    @RequestMapping(value = "/editRowStudent", method = RequestMethod.POST)
    @ResponseBody
    public StudentViewModel editRowStudent(@RequestBody StudentViewModel studentViewModel) {

        List<String> list = studentViewModel.getListid();

        StudentEntity studentEntity = studentService.findById(Integer.valueOf(list.get(0)));
        return  conversionService.convert(studentEntity, StudentViewModel.class);

        // return (List<RequestViewModel>) conversionService.convert(requestService.find(), requestEntityDescriptor, requestViewModelDescriptor);
    }

    @RequestMapping(value = "/editStudentBase", method = RequestMethod.POST)
    @ResponseBody
    public StudentViewModel editStudentBase(@RequestBody StudentViewModel studentViewModel) {

        List<String> list = studentViewModel.getListid();
        StudentEntity studentEntity = studentService.findById(Integer.valueOf(list.get(0)));
        studentEntity.setSurname(studentViewModel.getSurname());
        studentEntity.setAvscore(Double.valueOf(studentViewModel.getAvscore()));
        studentEntity.setBudjet(studentViewModel.getBudjet());
        studentEntity.setNamestud(studentViewModel.getNamestud());
        SpecialityEntity specialityEntity = specialityService.findById(Integer.valueOf(studentViewModel.getSpecialityId()));
        studentEntity.setSpecialityEntity(specialityEntity);
        studentEntity.setGroupstud(Integer.valueOf(studentViewModel.getGroupstud()));

        studentService.addStudent(studentEntity);
        return  conversionService.convert(studentEntity, StudentViewModel.class);

        // return (List<RequestViewModel>) conversionService.convert(requestService.find(), requestEntityDescriptor, requestViewModelDescriptor);
    }



    @RequestMapping(value = "/releseStydentPractice", method = RequestMethod.POST)
    @ResponseBody
    public   List<RequestEntity> releaseStudent(@RequestBody StudentViewModel studentViewModel) {

        List<String> list = studentViewModel.getListid();
        StudentEntity studentEntity = studentService.findById(Integer.valueOf(list.get(0)));
        List<RequestEntity> requestEntityList = studentEntity.getRequest();

        return requestEntityList;

        // return (List<RequestViewModel>) conversionService.convert(requestService.find(), requestEntityDescriptor, requestViewModelDescriptor);
    }
    @RequestMapping(value = "/releaseStudents", method = RequestMethod.POST)
    @ResponseBody
    public   StudentViewModel releaseStudentS(@RequestBody StudentViewModel studentViewModel) {

            List<String> list = studentViewModel.getListid();
            StudentEntity studentEntity = studentService.findById(Integer.valueOf(list.get(0)));

            List<String> request = studentViewModel.getRequestsId();
            for (String string : request)
            {
                RequestEntity requestEntity = requestService.findById(Integer.valueOf(string));
                requestEntity.getStudent().remove(studentEntity);
                Integer quantity = requestEntity.getQuantity();
                quantity++;
                requestEntity.setQuantity(quantity);
                requestService.addRequest(requestEntity);

            }
        StudentEntity studentEntity2 = studentService.findById(Integer.valueOf(list.get(0)));
            if (studentEntity2.getRequest().size()==0)
                studentEntity2.setStatusstud("NeRaspredeln");
            studentService.addStudent(studentEntity2);



    return conversionService.convert(studentEntity2, StudentViewModel.class);

        // return (List<RequestViewModel>) conversionService.convert(requestService.find(), requestEntityDescriptor, requestViewModelDescriptor);
    }









    @RequestMapping(value = "/addAssign", method = RequestMethod.POST)
    @ResponseBody
    public List<StudentViewModel> addAssign(@RequestBody AssignDto assignDto) {
        RequestEntity requestEntity = requestService.findById(assignDto.getRequestId());
        Integer quantity = requestEntity.getQuantity();
        int countofstudents = 0;
        for(Integer id:assignDto.getStudents())

        {
            countofstudents++;
            StudentEntity studentEntity = studentService.findById(id);
            studentEntity.setStatusstud("Raspredelen");
            studentService.addStudent(studentEntity);
            requestEntity.getStudent().add(studentEntity);
        }
        quantity = quantity - countofstudents;
            if (quantity>=0) {
                requestEntity.setQuantity(quantity);
                requestService.addRequest(requestEntity);
            }

        List<StudentEntity> allstudents = studentService.findall();
    return (List<StudentViewModel>) conversionService.convert(allstudents, studentEntityDescriptor, studentViewModelDescriptor);


    }




    @RequestMapping(value = "/studentsForTable", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentViewModel> getAllStudents() {
        List<StudentEntity> allstudents = studentService.findall();
        return (List<StudentViewModel>) conversionService.convert(allstudents, studentEntityDescriptor, studentViewModelDescriptor);
    }
    @RequestMapping(value = "/requestsForTable", method = RequestMethod.GET)
    @ResponseBody
    public List<RequestViewModel> getAllRequests() {
        List<RequestEntity> allrequests = requestService.find();
        return (List<RequestViewModel>) conversionService.convert(allrequests, requestEntityDescriptor, requestViewModelDescriptor);
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