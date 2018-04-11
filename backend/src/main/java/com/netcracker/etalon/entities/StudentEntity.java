package com.netcracker.etalon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "student", schema = "navr", catalog = "")
public class StudentEntity {
    private int id;
    private String surname;
    private String namestud;
    private SpecialityEntity specialityEntity;
    private Integer groupstud;
    private String budjet;
    private Double avscore;
    private Integer statusstud;
    private List<RequestEntity> request =  new ArrayList<>();

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "namestud")
    public String getNamestud() {
        return namestud;
    }

    public void setNamestud(String namestud) {
        this.namestud = namestud;
    }

    @Basic
    @Column(name = "groupstud")
    public Integer getGroupstud() {
        return groupstud;
    }

    public void setGroupstud(Integer groupstud) {
        this.groupstud = groupstud;
    }

    @Basic
    @Column(name = "budjet")
    public String getBudjet() {
        return budjet;
    }

    public void setBudjet(String budjet) {
        this.budjet = budjet;
    }

    @Basic
    @Column(name = "avscore")
    public Double getAvscore() {
        return avscore;
    }

    public void setAvscore(Double avscore) {
        this.avscore = avscore;
    }

    @Basic
    @Column(name = "statusstud")
    public Integer getStatusstud() {
        return statusstud;
    }

    public void setStatusstud(Integer statusstud) {
        this.statusstud = statusstud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return id == that.id &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(namestud, that.namestud) &&
                Objects.equals(groupstud, that.groupstud) &&
                Objects.equals(budjet, that.budjet) &&
                Objects.equals(avscore, that.avscore) &&
                Objects.equals(statusstud, that.statusstud);
    }
    @ManyToOne
    @JoinColumn(name = "spec_id", referencedColumnName = "id", nullable = false)
    public SpecialityEntity getSpecialityEntity() {
        return specialityEntity;
    }


    public void setSpecialityEntity(SpecialityEntity specialityEntity) {
        this.specialityEntity = specialityEntity;
    }

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE, mappedBy = "student")
    public List<RequestEntity> getRequest() {
        return request;
    }

    public void setRequest(List<RequestEntity> request) {
        this.request = request;
    }
    @Override
    public int hashCode() {

        return Objects.hash(id, surname, namestud, groupstud, budjet, avscore, statusstud);
    }
}
