package com.netcracker.etalon.models;

public class RequestViewModel {
    private String id;
    private String name;
    private String datestart;
    private String datefinish;
    private SpecialityViewModel specialityViewModel;
    private String minavscore;
    private String quantity;

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

    public SpecialityViewModel getSpecialityViewModel() {
        return specialityViewModel;
    }

    public void setSpecialityViewModel(SpecialityViewModel specialityViewModel) {
        this.specialityViewModel = specialityViewModel;
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
