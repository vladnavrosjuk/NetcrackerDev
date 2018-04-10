package com.netcracker.etalon.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "request", schema = "navr", catalog = "")
public class RequestEntity {
    private int id;
    private String namecompany;
    private Date datestart;
    private Date datefinish;
    private Double minavscore;
    private Integer quantity;
    private List<StudentEntity> student = new ArrayList<>();
    private SpecialityEntity specialityEntity;


    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "namecompany")
    public String getNamecompany() {
        return namecompany;
    }

    public void setNamecompany(String namecompany) {
        this.namecompany = namecompany;
    }

    @Basic
    @Column(name = "datestart")
    public Date getDatestart() {
        return datestart;
    }

    public void setDatestart(Date datestart) {
        this.datestart = datestart;
    }

    @Basic
    @Column(name = "datefinish")
    public Date getDatefinish() {
        return datefinish;
    }

    public void setDatefinish(Date datefinish) {
        this.datefinish = datefinish;
    }

    @Basic
    @Column(name = "minavscore")
    public Double getMinavscore() {
        return minavscore;
    }

    public void setMinavscore(Double minavscore) {
        this.minavscore = minavscore;
    }

    @Basic
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestEntity that = (RequestEntity) o;
        return id == that.id &&
                Objects.equals(namecompany, that.namecompany) &&
                Objects.equals(datestart, that.datestart) &&
                Objects.equals(datefinish, that.datefinish) &&
                Objects.equals(minavscore, that.minavscore) &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, namecompany, datestart, datefinish, minavscore, quantity);
    }

    @ManyToOne
    @JoinColumn(name = "idspeciality", referencedColumnName = "id", nullable = false)
    public SpecialityEntity getSpecialityEntity() {
        return specialityEntity;
    }

    public void setSpecialityEntity(SpecialityEntity specialityEntity) {
        this.specialityEntity = specialityEntity;
    }

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "requstandstudent", catalog = "", schema = "navr", joinColumns = @JoinColumn(name = "idrequest", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "idstudent", referencedColumnName = "id"))
    public List<StudentEntity> getStudent() {
        return student;
    }

    public void setStudent(List<StudentEntity> student) {
        this.student = student;
    }
}
