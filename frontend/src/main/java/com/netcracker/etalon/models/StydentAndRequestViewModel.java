package com.netcracker.etalon.models;

import java.util.ArrayList;
import java.util.List;

public class StydentAndRequestViewModel {
    private String idStudent;
    private String idRequestCompany;
    private List<String> listRequest = new ArrayList<>();
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
    private String name;
    private String datestart;
    private String datefinish;

    private String minavscore;
    private String quantity;
    private String idSpeciality;
    private String specialityName;


    public List<String> getListRequest() {
        return listRequest;
    }

    public void setListRequest(List<String> listRequest) {
        this.listRequest = listRequest;
    }

    public String getIdRequestCompany() {
        return idRequestCompany;
    }

    public void setIdRequestCompany(String idRequestCompany) {
        this.idRequestCompany = idRequestCompany;
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

    public String getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(String specialityId) {
        this.specialityId = specialityId;
    }

    public String getFacultet() {
        return facultet;
    }

    public void setFacultet(String facultet) {
        this.facultet = facultet;
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

    public String getFacultetid() {
        return facultetid;
    }

    public void setFacultetid(String facultetid) {
        this.facultetid = facultetid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatestart() {
        return datestart;
    }

    public void setDatestart(String datestart) {
        this.datestart = datestart;
    }

    public String getDatefinish() {
        return datefinish;
    }

    public void setDatefinish(String datefinish) {
        this.datefinish = datefinish;
    }

    public String getMinavscore() {
        return minavscore;
    }

    public void setMinavscore(String minavscore) {
        this.minavscore = minavscore;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(String idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }
}

