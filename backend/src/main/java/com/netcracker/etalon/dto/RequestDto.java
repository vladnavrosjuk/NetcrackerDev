package com.netcracker.etalon.dto;

import com.netcracker.etalon.entities.StudentEntity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class RequestDto {
    private List<String> students =new ArrayList<>();
    private String namecompany;
    private Date datestart;
    private Date datefinish;
    private Double minavscore;
    private Integer quantity;
    private Integer facultetid;

    public String getNamecompany() {
        return namecompany;
    }

    public void setNamecompany(String namecompany) {
        this.namecompany = namecompany;
    }

    public Date getDatestart() {
        return datestart;
    }

    public void setDatestart(Date datestart) {
        this.datestart = datestart;
    }

    public Date getDatefinish() {
        return datefinish;
    }

    public void setDatefinish(Date datefinish) {
        this.datefinish = datefinish;
    }

    public Double getMinavscore() {
        return minavscore;
    }

    public void setMinavscore(Double minavscore) {
        this.minavscore = minavscore;
    }

    public Integer getFacultetid() {
        return facultetid;
    }

    public void setFacultetid(Integer facultetid) {
        this.facultetid = facultetid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }
}
