package com.netcracker.etalon.dto;

import com.netcracker.etalon.entities.SpecialityEntity;

public class StudentDTO {
    private Integer namefaculity;
    private String specialityid;
    private String surname;
    private String namestud;

    private Integer groupstud;
    private String budjet;
    private Double avscore;
    private Integer statusstud;

    public Integer getNamefaculity() {
        return namefaculity;
    }

    public void setNamefaculity(Integer namefaculity) {
        this.namefaculity = namefaculity;
    }

    public String getSpecialityid() {
        return specialityid;
    }

    public void setSpecialityid(String specialityid) {
        this.specialityid = specialityid;
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

    public Integer getGroupstud() {
        return groupstud;
    }

    public void setGroupstud(Integer groupstud) {
        this.groupstud = groupstud;
    }

    public String getBudjet() {
        return budjet;
    }

    public void setBudjet(String budjet) {
        this.budjet = budjet;
    }

    public Double getAvscore() {
        return avscore;
    }

    public void setAvscore(Double avscore) {
        this.avscore = avscore;
    }

    public Integer getStatusstud() {
        return statusstud;
    }

    public void setStatusstud(Integer statusstud) {
        this.statusstud = statusstud;
    }
}
