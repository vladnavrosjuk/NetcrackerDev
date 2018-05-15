package com.netcracker.etalon.controllers;

import com.netcracker.etalon.dto.RequestDto;
import com.netcracker.etalon.entities.*;
import com.netcracker.etalon.models.RequestViewModel;
import com.netcracker.etalon.models.StudentViewModel;
import com.netcracker.etalon.models.StydentAndRequestViewModel;
import com.netcracker.etalon.security.impl.CustomUser;
import com.netcracker.etalon.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private CoordinateService coordinateService;

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
            if (requestEntity!=null) {
            /*UserEntity userEntity = userService.findByRequestEntity(requestEntity);
            if (userEntity!=null)
            userService.deleteById(userEntity.getId());*/
                for (StudentEntity studentEntity : requestEntity.getStudent()) {
                    studentEntity.setStatusstud(STATUS_OF_PRACTICE_NO_DISTR);
                    studentService.addStudent(studentEntity);
                }
                requestEntity.getStudent().clear();
                requestService.addRequest(requestEntity);

                requestService.deleteById(Integer.valueOf(id));
            }
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

    @RequestMapping(value = "/saveRequestCoordinate", method = RequestMethod.POST)
    @ResponseBody
    public void saveRequestCoordinate(@RequestBody RequestViewModel requestViewModel) {
        RequestEntity requestEntity = requestService.findById(Integer.valueOf(requestViewModel.getIdRequestList().get(0)) );

        if (coordinateService.findByRequest(requestEntity)==null){
            CoordinatEntity coordinatEntity = new CoordinatEntity();
        coordinatEntity.setRequest(requestEntity);
        coordinatEntity.setLat(requestViewModel.getLat());
        coordinatEntity.setLng(requestViewModel.getLan());

        coordinateService.addCoordinate(coordinatEntity);}
        else {
            CoordinatEntity coordinatEntity = coordinateService.findByRequest(requestEntity);
            coordinatEntity.setRequest(requestEntity);
            coordinatEntity.setLat(requestViewModel.getLat());
            coordinatEntity.setLng(requestViewModel.getLan());
            coordinateService.addCoordinate(coordinatEntity);

        }







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
    public ModelMap requestTable(@RequestParam String search,  @RequestParam String sort, @RequestParam String order, @RequestParam Integer offset, @RequestParam Integer limit){

        ModelMap modelMap = new ModelMap();
        List<RequestEntity> requestEntityList = requestPaginationService.getPaginationAndSortedPageList(search, sort,order,offset,limit);
        List<RequestViewModel>  list = (List<RequestViewModel>) conversionService.convert(requestEntityList, requestEntityDescriptor, requestViewModelDescriptor);
        modelMap.addAttribute("rows", list);
        if (search=="")
        modelMap.addAttribute("total", requestService.find().size());
        else
            modelMap.addAttribute("total",requestService.searchbyname("%"+search+"%").size());
        return modelMap;
    }
    @RequestMapping(value = "/setRequestNameRole", method = RequestMethod.GET)
    @ResponseBody
    public String  requestName(){
        CustomUser customUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(customUser.getUsername());
        UserEntity userEntity = userService.find(customUser.getUsername()).get(0);
        RequestEntity requestEntity = userEntity.getRequestEntity();
        String name = requestEntity.getNamecompany() ;






        return name;
    }

    @RequestMapping(value = "/getRequestTableRole", method = RequestMethod.GET)
    @ResponseBody
    public  List<StydentAndRequestViewModel>  getRequestTable(){
        CustomUser customUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserEntity userEntity = userService.find(customUser.getUsername()).get(0);
        RequestEntity requestEntity = userEntity.getRequestEntity();
        String name = requestEntity.getNamecompany() ;
        StydentAndRequestViewModel stydentAndRequestViewModel = new StydentAndRequestViewModel();
        stydentAndRequestViewModel.setName(requestEntity.getNamecompany());

        List<StudentEntity> studentEntityList = requestEntity.getStudent();
        SpecialityEntity specialityEntity = requestEntity.getSpecialityEntity();
        FacultetEntity facultetEntity = specialityEntity.getFacultetEntity();
        List<StydentAndRequestViewModel> stydentAndRequestViewModelList = new ArrayList<>();
        if (studentEntityList.size()==0) {
            stydentAndRequestViewModel.setDatestart(String.valueOf(requestEntity.getDatestart()));
            stydentAndRequestViewModel.setDatefinish(String.valueOf(requestEntity.getDatefinish()));
            stydentAndRequestViewModel.setSpeciality(specialityEntity.getName());
            stydentAndRequestViewModel.setFacultet(facultetEntity.getName());
            stydentAndRequestViewModel.setQuantity(String.valueOf(requestEntity.getQuantity()));
            stydentAndRequestViewModelList.add(stydentAndRequestViewModel);
        }
        for (StudentEntity studentEntity:studentEntityList){
            StydentAndRequestViewModel stud = new StydentAndRequestViewModel();
            stud.setDatestart(String.valueOf(requestEntity.getDatestart()));
            stud.setName(requestEntity.getNamecompany());
            stud.setBudjet(studentEntity.getBudjet());
            stud.setDatefinish(String.valueOf(requestEntity.getDatefinish()));
            stud.setSpeciality(specialityEntity.getName());
            stud.setFacultet(facultetEntity.getName());
            stud.setQuantity(String.valueOf(requestEntity.getQuantity()));
            stud.setNamestud(studentEntity.getNamestud());

            stud.setSurname(studentEntity.getSurname());
            stud.setGroupstud(String.valueOf(studentEntity.getGroupstud()));
            stud.setAvscore(String.valueOf(studentEntity.getAvscore()));
            stydentAndRequestViewModelList.add(stud);
        }




        return stydentAndRequestViewModelList;
    }

    @RequestMapping(value = "/setRolePrint", method = RequestMethod.GET)
    @ResponseBody
    public StringBuilder  setRolePrint(){
        CustomUser customUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(customUser.getUsername());
        UserEntity userEntity = userService.find(customUser.getUsername()).get(0);
        RequestEntity requestEntity = userEntity.getRequestEntity();
        List<StudentEntity> studentEntityList = requestEntity.getStudent();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<center>"+"<strong>"+"Company :"+"</strong>"+"</center>"+"<br>");
        stringBuilder.append("NameCompany:"+requestEntity.getNamecompany()+"<br>");
        stringBuilder.append("DateStart:" + requestEntity.getDatestart()+"<br>");
        stringBuilder.append("DateFinish:" + requestEntity.getDatefinish()+"<br>");
        stringBuilder.append("Quantity:" + requestEntity.getQuantity()+"<br>");
        stringBuilder.append("Students:" +studentEntityList.size()+"<br>");










        int i = 0;
        for(StudentEntity studentEntity: studentEntityList)
        {   i++;
            stringBuilder.append("<center>"+"Student:"+i+"</center>"+"<br>");
            stringBuilder.append("Name:"+studentEntity.getNamestud()+"<br>");
            stringBuilder.append("Surname:" + studentEntity.getSurname()+"<br>");



            SpecialityEntity specialityEntity = studentEntity.getSpecialityEntity();
            stringBuilder.append("Speciality:"+specialityEntity.getName()+"<br>");
            FacultetEntity facultetEntity = specialityEntity.getFacultetEntity();
            stringBuilder.append("Facultet:"+facultetEntity.getName()+"<br>");
            stringBuilder.append("Group:"+studentEntity.getGroupstud()+"<br>");
            stringBuilder.append("AvScore:"+studentEntity.getAvscore()+"<br>");

        }
        System.out.println("lol");


        return stringBuilder;
    }

    @RequestMapping(value = "/setInfoAboutRequest", method = RequestMethod.GET)
    @ResponseBody
    public RequestViewModel  setInfoAboutStudent(){
        CustomUser customUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(customUser.getUsername());
        UserEntity userEntity = userService.find(customUser.getUsername()).get(0);
        RequestEntity requestEntity = userEntity.getRequestEntity();
        RequestViewModel requestViewModel = new RequestViewModel();
        requestViewModel.setName(requestEntity.getNamecompany());
        requestViewModel.setDatestart(String.valueOf(requestEntity.getDatestart()));
        requestViewModel.setDatefinish(String.valueOf(requestEntity.getDatefinish()));
        requestViewModel.setQuantity(String.valueOf(requestEntity.getQuantity()));




        return requestViewModel;
    }



}
