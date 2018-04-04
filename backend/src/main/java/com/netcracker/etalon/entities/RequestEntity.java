package com.netcracker.etalon.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "request", schema = "navr", catalog = "")
public class RequestEntity {
    private int id;
    private Integer name;
    private List<StudentEntity> stud;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestEntity that = (RequestEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @ManyToMany
    @JoinTable(name = "requstandstudent", catalog = "", schema = "navr", joinColumns = @JoinColumn(name = "idrequest"), inverseJoinColumns = @JoinColumn(name = "idstudent"))
    public List<StudentEntity> getStud() {
        return stud;
    }

    public void setStud(List<StudentEntity> stud) {
        this.stud = stud;
    }
}
