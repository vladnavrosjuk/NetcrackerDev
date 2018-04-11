package com.netcracker.etalon.models;

import com.netcracker.etalon.entities.SpecialityEntity;

import java.util.ArrayList;
import java.util.List;

public class StudentViewModel {
    private List<String> listid = new ArrayList<>();
    private String idStudent;
    private String surname;
    private String namestud;
    private String speciality;
    private String specialityId;
    private String facultet;
    private String groupstud;
    private String budjet;
    private String avscore;
    private String statusstud;
    private String facultetid;




    public String getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(String specialityId) {
        this.specialityId = specialityId;
    }

    public String getFacultetid() {
        return facultetid;
    }

    public void setFacultetid(String facultetid) {
        this.facultetid = facultetid;
    }

    public List<String> getListid() {
        return listid;
    }

    public void setListid(List<String> listid) {
        this.listid = listid;
    }

    public String getFacultet() {
        return facultet;
    }

    public void setFacultet(String facultet) {
        this.facultet = facultet;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNamestud() {
        return namestud;
    }

    public void setNamestud(String namestud) {
        this.namestud = namestud;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getGroupstud() {
        return groupstud;
    }

    public void setGroupstud(String groupstud) {
        this.groupstud = groupstud;
    }

    public String getBudjet() {
        return budjet;
    }

    public void setBudjet(String budjet) {
        this.budjet = budjet;
    }

    public String getAvscore() {
        return avscore;
    }

    public void setAvscore(String avscore) {
        this.avscore = avscore;
    }

    public String getStatusstud() {
        return statusstud;
    }

    public void setStatusstud(String statusstud) {
        this.statusstud = statusstud;
    }
}
