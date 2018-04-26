package com.netcracker.etalon.controllers;

import com.netcracker.etalon.dto.AssignDto;
import com.netcracker.etalon.entities.*;
import com.netcracker.etalon.models.RequestViewModel;
import com.netcracker.etalon.models.StudentViewModel;
import com.netcracker.etalon.models.StydentAndRequestViewModel;
import com.netcracker.etalon.security.impl.CustomUser;
import com.netcracker.etalon.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
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
    private StudentPaginationService studentPaginationService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    private static final String STATUS_OF_PRACTICE_DISTR = "Awaits practice";
    private static  final String STATUS_OF_PRACTICE_NO_DISTR = "N0 DISTRIBUTED";
    private static  final String STATUS_OF_PRACTICE_IN_PRACTICE = "On practice";
    private  final TypeDescriptor requestEntityDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RequestEntity.class));
    private  final TypeDescriptor requestViewModelDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(RequestViewModel.class));


    private  final TypeDescriptor studentEntityDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentEntity.class));
    private  final TypeDescriptor studentViewModelDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentViewModel.class));

    private static final String VIEW_NAME_LOGIN = "adminpage";
    private static final String VIEW_ALL_REQUEST = "request";


    @RequestMapping(value = "/testel", method = RequestMethod.POST)
    @ResponseBody
    public void asd(@RequestBody StudentViewModel studentViewModel) {
        CustomUser customUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(customUser.getUsername());
        List<String> list = studentViewModel.getListid();
        for (String id : list){
            StudentEntity studentEntity = studentService.findById(Integer.valueOf(id));
            UserEntity userEntity = userService.findByStudentEntity(studentEntity);


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
    @RequestMapping(value = "/infoaboustudent", method = RequestMethod.POST)
    @ResponseBody
    public List<RequestViewModel> aboutStudent (@RequestBody StudentViewModel studentViewModel) {
        List<String> list = studentViewModel.getListid();
        StudentEntity studentEntity = studentService.findById(Integer.valueOf(list.get(0)));



         return (List<RequestViewModel>) conversionService.convert(studentEntity.getRequest(), requestEntityDescriptor, requestViewModelDescriptor);
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
        List<StudentEntity> studentEntityList = studentService.findall();
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
            studentEntity2.setStatusstud(STATUS_OF_PRACTICE_NO_DISTR);
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
            studentEntity.setStatusstud(STATUS_OF_PRACTICE_DISTR);
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

    @RequestMapping(value = "/studentTableBootstrap", method = RequestMethod.GET)
    @ResponseBody
    public ModelMap studentTable(@RequestParam String search, @RequestParam String sort, @RequestParam String order, @RequestParam Integer offset, @RequestParam Integer limit){

        ModelMap modelMap = new ModelMap();
        List<StudentEntity> studentEntityList = studentPaginationService.getPaginationAndSortedPageList(sort,order,offset,limit);
         List<StudentViewModel>  list = (List<StudentViewModel>) conversionService.convert(studentEntityList, studentEntityDescriptor, studentViewModelDescriptor);
        modelMap.addAttribute("rows", list);
        modelMap.addAttribute("total", studentService.findall().size());
        return modelMap;
    }



    @RequestMapping(value = "/setStudentName", method = RequestMethod.GET)
    @ResponseBody
    public String  studentTable(){
        CustomUser customUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(customUser.getUsername());
        UserEntity userEntity = userService.find(customUser.getUsername()).get(0);
        StudentEntity studentEntity = userEntity.getStudentEntity();
        String name = studentEntity.getNamestud() + " " + studentEntity.getSurname();



      return name;
    }
    @RequestMapping(value = "/seTabletStudentRole", method = RequestMethod.GET)
    @ResponseBody
    public List<StydentAndRequestViewModel>  seTabletStudentRole(){
        CustomUser customUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(customUser.getUsername());
        UserEntity userEntity = userService.find(customUser.getUsername()).get(0);
        StudentEntity studentEntity = userEntity.getStudentEntity();
        List<RequestEntity> requestEntities = studentEntity.getRequest();
        List<StydentAndRequestViewModel> stydentAndRequestViewModelList = new ArrayList<>();
        if (requestEntities.size() == 0)
        {
            StydentAndRequestViewModel stydentAndRequestViewModel  =  new StydentAndRequestViewModel();
            stydentAndRequestViewModel.setNamestud(studentEntity.getNamestud());
            stydentAndRequestViewModel.setSurname(studentEntity.getSurname());
            SpecialityEntity specialityEntity = studentEntity.getSpecialityEntity();
            stydentAndRequestViewModel.setSpeciality(specialityEntity.getName());
            FacultetEntity facultetEntity = specialityEntity.getFacultetEntity();
            stydentAndRequestViewModel.setFacultet(facultetEntity.getName());
            stydentAndRequestViewModel.setGroupstud(String.valueOf(studentEntity.getGroupstud()));
            stydentAndRequestViewModel.setBudjet(studentEntity.getBudjet());
            stydentAndRequestViewModel.setAvscore(String.valueOf(studentEntity.getAvscore()));
            stydentAndRequestViewModelList.add(stydentAndRequestViewModel);

        }
        for(RequestEntity requestEntity: requestEntities)
        {
            StydentAndRequestViewModel stydentAndRequestViewModel  =  new StydentAndRequestViewModel();
            stydentAndRequestViewModel.setNamestud(studentEntity.getNamestud());
            stydentAndRequestViewModel.setSurname(studentEntity.getSurname());
            SpecialityEntity specialityEntity = studentEntity.getSpecialityEntity();
            stydentAndRequestViewModel.setSpeciality(specialityEntity.getName());
            FacultetEntity facultetEntity = specialityEntity.getFacultetEntity();
            stydentAndRequestViewModel.setFacultet(facultetEntity.getName());
            stydentAndRequestViewModel.setGroupstud(String.valueOf(studentEntity.getGroupstud()));
            stydentAndRequestViewModel.setBudjet(studentEntity.getBudjet());
            stydentAndRequestViewModel.setAvscore(String.valueOf(studentEntity.getAvscore()));
            stydentAndRequestViewModel.setName(requestEntity.getNamecompany());
            stydentAndRequestViewModel.setDatestart(String.valueOf(requestEntity.getDatestart()));
            stydentAndRequestViewModel.setDatefinish(String.valueOf(requestEntity.getDatefinish()));
            stydentAndRequestViewModelList.add(stydentAndRequestViewModel);

        }
        System.out.println("lol");


        return stydentAndRequestViewModelList;
    }
    @RequestMapping(value = "/request-page", method = RequestMethod.GET)
    public ModelAndView getAdminPage() {


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("requestRole");

        return modelAndView;
    }

}
