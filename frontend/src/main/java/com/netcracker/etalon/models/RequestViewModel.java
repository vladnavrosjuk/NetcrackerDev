package com.netcracker.etalon.models;

import java.util.ArrayList;
import java.util.List;

public class RequestViewModel {
    private List<String> idRequestList =  new ArrayList<>();
    private String idRequest;
    private String name;
    private String datestart;
    private String datefinish;

    private String minavscore;
    private String quantity;

    public List<String> getIdRequestList() {
        return idRequestList;
    }

    public void setIdRequestList(List<String> idRequestList) {
        this.idRequestList = idRequestList;
    }

    public String getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(String idRequest) {
        this.idRequest = idRequest;
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
}
