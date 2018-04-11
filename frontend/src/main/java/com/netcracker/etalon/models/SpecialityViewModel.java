package com.netcracker.etalon.models;

import java.util.ArrayList;
import java.util.List;

public class SpecialityViewModel {
    private List<String> listid = new ArrayList<>();
    private String id;
    private String name;
    private FacultyViewModel facultyViewModel;

    public List<String> getListid() {
        return listid;
    }

    public void setListid(List<String> listid) {
        this.listid = listid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FacultyViewModel getFacultyViewModel() {
        return facultyViewModel;
    }

    public void setFacultyViewModel(FacultyViewModel facultyViewModel) {
        this.facultyViewModel = facultyViewModel;
    }
}
