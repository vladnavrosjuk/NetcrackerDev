package com.netcracker.etalon.controllers;


import com.netcracker.etalon.dto.*;
import com.netcracker.etalon.entities.*;
import com.netcracker.etalon.models.RequestViewModel;
import com.netcracker.etalon.models.StudentViewModel;
import com.netcracker.etalon.services.*;
import com.netcracker.etalon.validator.ValidRequest;
import com.netcracker.etalon.validator.ValidStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller

public class AdminController {
    @Autowired
    ValidRequest validRequest;
    @Autowired
    ValidStudent validStudent;
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
    private RegistrationService registrationService;
    @Autowired
    private UserService userService;

    private  final TypeDescriptor requestEntityDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RequestEntity.class));
    private  final TypeDescriptor requestViewModelDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RequestViewModel.class));


    private  final TypeDescriptor studentEntityDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentEntity.class));
    private  final TypeDescriptor studentViewModelDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentViewModel.class));
    private static final String STATUS_OF_PRACTICE_DISTR = "Awaits practice";
    private static  final String STATUS_OF_PRACTICE_NO_DISTR = "NO DISTRIBUTED";
    private static  final String STATUS_OF_PRACTICE_IN_PRACTICE = "On practice";
    private static final String VIEW_NAME_LOGIN = "adminpage";
    private static final String VIEW_ALL_REQUEST = "request";
    private static final String VIEW_LOGIN_PAGE = "loginpage";
    private static final String VIEW_USER_PAGE = "userPage";
    private static final String VIEW_ADMIN_PAGE = "adminpage";
    private static final String VIEW_COMPANY_PAGE = "companyPage";




    @RequestMapping(value = "/autorization", method = RequestMethod.GET)
    public ModelAndView getAutorization() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VIEW_LOGIN_PAGE);

        return modelAndView;
    }


    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public ModelAndView gettest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VIEW_USER_PAGE);//constants

        return modelAndView;
    }

    @RequestMapping(value = "/requestPage", method = RequestMethod.GET)
    public ModelAndView gettestreq() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VIEW_COMPANY_PAGE  );//constants

        return modelAndView;
    }




    @RequestMapping(value = "/allRequest", method = RequestMethod.GET)//?
    public ModelAndView getAllrequest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VIEW_ALL_REQUEST);//constants

        return modelAndView;
    }





    @RequestMapping(value = "/adminPage", method = RequestMethod.GET)
    public ModelAndView getAdminPage() {


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VIEW_ADMIN_PAGE);

        return modelAndView;
    }

    @RequestMapping(value = "/dropdown", method = RequestMethod.GET)
    @ResponseBody
    public List<FacultetEntity> getAdminPageDropdown() {

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

    @RequestMapping(value = "/specialityForFirstFaculty", method = RequestMethod.GET)
    @ResponseBody
    public List<SpecialityEntity> specialityForFirstFaculty() {
        FacultetEntity facultetEntity = facultyService.findByid(1);
        return specialityService.findByFacultetEntity(facultetEntity);


    }

    @RequestMapping(value = "/specialityForFaculty", method = RequestMethod.POST)
    @ResponseBody
    public List<SpecialityEntity> specialityForFaculty(@RequestBody SpecialityDto specialityDto) {
        FacultetEntity facultetEntity = facultyService.findByid(specialityDto.getFacultetId());
        return specialityService.findByFacultetEntity(facultetEntity);


    }


    @RequestMapping(value = "/addRequest", method = RequestMethod.POST)
    @ResponseBody
    public RequestEntity addRequest(@RequestBody RequestDto requestDto) {
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setNamecompany(requestDto.getNamecompany());

        SpecialityEntity specialitentity = specialityService.findById(requestDto.getFacultetid());
        requestEntity.setSpecialityEntity(specialitentity);
        requestEntity.setDatestart(requestDto.getDatestart());
        requestEntity.setDatefinish(requestDto.getDatefinish());
        requestEntity.setMinavscore(requestDto.getMinavscore());
        requestEntity.setQuantity(requestDto.getQuantity());
        if (validRequest.validRequest(requestEntity)) {
            requestService.addRequest(requestEntity);
            return  requestEntity;
        }
        else return null;

    }


    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    @ResponseBody
    public StudentViewModel addStudent(@RequestBody StudentDTO studentDTO) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setGroupstud(studentDTO.getGroupstud());
        studentEntity.setNamestud(studentDTO.getNamestud());
        studentEntity.setSpecialityEntity(specialityService.findById(studentDTO.getSpecialityid()));
        studentEntity.setSurname(studentDTO.getSurname());
        studentEntity.setBudjet(studentDTO.getBudjet());
        studentEntity.setAvscore(studentDTO.getAvscore());
        studentEntity.setStatusstud(STATUS_OF_PRACTICE_NO_DISTR);
        if (validStudent.validStudent(studentEntity))
        {

            studentService.addStudent(studentEntity);

            StudentEntity studentEntitymax = studentService.findById(studentService.maxId());
            List<StudentEntity> studentEntityList = new ArrayList<>();
            studentEntityList.add(studentEntitymax);
            return  conversionService.convert(studentEntitymax, StudentViewModel.class);
        }
        return null;



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


    @RequestMapping(value = "/findRequest", method = RequestMethod.POST)
    @ResponseBody
    public RequestEntity findRequest(@RequestBody RequestDto requestDto) {
        RequestEntity requestEntity = requestService.findById(requestDto.getId());

        return requestEntity;
    }

    @RequestMapping(value = "/requestsForTable", method = RequestMethod.GET)
    @ResponseBody
    public List<RequestViewModel> getAllRequests() {
        List<RequestEntity> allrequests = requestService.find();
        return (List<RequestViewModel>) conversionService.convert(allrequests, requestEntityDescriptor, requestViewModelDescriptor);
    }

    @RequestMapping(value = "/findAllRegistrationRequest", method = RequestMethod.GET)
    @ResponseBody
    public List<RegistrationEntity> findAllRegistrationRequest() {
        List<RegistrationEntity> registrationEntities =registrationService.findAll();
        for (RegistrationEntity registrationEntity : registrationEntities)
        {
            if (registrationEntity.getRole().equals("1"))
                registrationEntity.setRole("Student");
            else registrationEntity.setRole("Company");
        }
        return  registrationEntities;
    }

    @RequestMapping(value = "/deleteRegistrRequest", method = RequestMethod.POST)
    @ResponseBody
    public void deleteRegistrRequest(@RequestBody RequestViewModel requestViewModel) {
        for (String id : requestViewModel.getIdRequestList())
        {
            registrationService.deleteById(Integer.valueOf(id));
        }

        System.out.println();
    }








}
