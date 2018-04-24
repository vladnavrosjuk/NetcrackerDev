package com.netcracker.etalon.controllers;

import com.netcracker.etalon.dto.RequestDto;
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
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

@Controller
public class RequestController {

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
    private RequestPaginationService requestPaginationService;
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
    private static final String STATUS_OF_PRACTICE_DISTR = "Awaits practice";
    private static  final String STATUS_OF_PRACTICE_NO_DISTR = "N0 DISTRIBUTED";
    private static  final String STATUS_OF_PRACTICE_IN_PRACTICE = "On practice";


    @RequestMapping(value = "/deleteRequest", method = RequestMethod.POST)
    @ResponseBody
    public void addFacultet(@RequestBody RequestViewModel requestViewModel) {

        List<String> listid = requestViewModel.getIdRequestList();
        for(String id : listid){
            RequestEntity requestEntity = requestService.findById(Integer.valueOf(id));
            for(StudentEntity studentEntity: requestEntity.getStudent()){
                studentEntity.setStatusstud(STATUS_OF_PRACTICE_NO_DISTR);
                studentService.addStudent(studentEntity);
            }
            requestEntity.getStudent().clear();
            requestService.addRequest(requestEntity);

            requestService.deleteById(Integer.valueOf(id));
        }


    }


    @RequestMapping(value = "/checkDatePractice", method = RequestMethod.POST)
    @ResponseBody
    public void checkDatePractice() {

            List<RequestEntity> requestEntityList = requestService.requestAfterCurentDate();
            for(RequestEntity requestEntity:requestEntityList){
                List<StudentEntity> studentEntityList = requestEntity.getStudent();
                    for (StudentEntity studentEntity:studentEntityList){
                        studentEntity.setStatusstud(STATUS_OF_PRACTICE_IN_PRACTICE);
                        studentService.addStudent(studentEntity);
                    }


            }


    }



    @RequestMapping(value = "/editRowRequest", method = RequestMethod.POST)
    @ResponseBody
    public RequestViewModel editRowRequest(@RequestBody RequestViewModel requestViewModel) {

        List<String> list = requestViewModel.getIdRequestList();

        RequestEntity requestEntity = requestService.findById(Integer.valueOf(list.get(0)));
        return  conversionService.convert(requestEntity, RequestViewModel.class);

        // return (List<RequestViewModel>) conversionService.convert(requestService.find(), requestEntityDescriptor, requestViewModelDescriptor);
    }


    @RequestMapping(value = "/editRowRequestBase", method = RequestMethod.POST)
    @ResponseBody
    public RequestViewModel editRowRequestBase(@RequestBody RequestViewModel requestViewModel) {
        //Сбился часовой пояс
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        List<String> list = requestViewModel.getIdRequestList();
        RequestEntity requestEntity = requestService.findById(Integer.valueOf(list.get(0)));
        try {
            java.util.Date parse =  format.parse(requestViewModel.getDatestart());
            java.util.Date parse2 =  format.parse(requestViewModel.getDatefinish());
            java.sql.Date sql = new java.sql.Date(parse.getTime());
            java.sql.Date sql2 = new java.sql.Date(parse2.getTime());
            requestEntity.setDatefinish(sql);
            requestEntity.setDatestart(sql2);


        } catch (ParseException e) {
            e.printStackTrace();
        }


        requestEntity.setQuantity(Integer.valueOf(requestViewModel.getQuantity()) );
        requestEntity.setMinavscore(Double.valueOf(requestViewModel.getMinavscore()));

        requestEntity.setNamecompany(requestViewModel.getName());
        SpecialityEntity specialityEntity = specialityService.findById(Integer.valueOf(requestViewModel.getIdSpeciality()));
        requestEntity.setSpecialityEntity(specialityEntity);
        requestService.addRequest(requestEntity);
        return  conversionService.convert(requestEntity, RequestViewModel.class);

        // return (List<RequestViewModel>) conversionService.convert(requestService.find(), requestEntityDescriptor, requestViewModelDescriptor);
    }


    @RequestMapping(value = "/multiselestReleaseRequest", method = RequestMethod.POST)
    @ResponseBody
    public  List<StudentEntity> multiselestReleaseRequest(@RequestBody RequestViewModel requestViewModel) {

        List<String> list = requestViewModel.getIdRequestList();
        RequestEntity requestEntity = requestService.findById(Integer.valueOf(list.get(0)));
        List<StudentEntity> studentEntityList = requestEntity.getStudent();

        return  studentEntityList;

        // return (List<RequestViewModel>) conversionService.convert(requestService.find(), requestEntityDescriptor, requestViewModelDescriptor);
    }

    @RequestMapping(value = "/releaseStudentFromRequest", method = RequestMethod.POST)
    @ResponseBody
    public RequestViewModel releaseStudentFromRequest(@RequestBody StudentViewModel studentViewModel) {
        List<String> studentidlist = studentViewModel.getListid();
        List<String> list = studentViewModel.getRequestsId();
        RequestEntity requestEntity = requestService.findById(Integer.valueOf(list.get(0)));
        for (String id: studentidlist){
            StudentEntity studentEntity = studentService.findById(Integer.valueOf(id));
            requestEntity.getStudent().remove(studentEntity);
            Integer quantity = requestEntity.getQuantity();
            quantity++;
            requestEntity.setQuantity(quantity);
            requestService.addRequest(requestEntity);
            StudentEntity studentEntity2 = studentService.findById(Integer.valueOf(id));
            if (studentEntity2.getRequest().size()==0){
                studentEntity2.setStatusstud(STATUS_OF_PRACTICE_NO_DISTR);
                studentService.addStudent(studentEntity2);
            }
        }
        return conversionService.convert(requestEntity, RequestViewModel.class);




        // return (List<RequestViewModel>) conversionService.convert(requestService.find(), requestEntityDescriptor, requestViewModelDescriptor);
    }
    @RequestMapping(value = "/requestTableBootstrap", method = RequestMethod.GET)
    @ResponseBody
    public ModelMap requestTable(@RequestParam String sort, @RequestParam String order, @RequestParam Integer offset, @RequestParam Integer limit){

        ModelMap modelMap = new ModelMap();
        List<RequestEntity> requestEntityList = requestPaginationService.getPaginationAndSortedPageList(sort,order,offset,limit);
        List<RequestViewModel>  list = (List<RequestViewModel>) conversionService.convert(requestEntityList, requestEntityDescriptor, requestViewModelDescriptor);
        modelMap.addAttribute("rows", list);
        modelMap.addAttribute("total", requestService.find().size());
        return modelMap;
    }
}
