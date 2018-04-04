package com.netcracker.etalon.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "speciality", schema = "navr", catalog = "")
public class SpecialityEntity {
    private int id;
    private String name;

    private FacultetEntity faculty;



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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 /*   @Basic
    @Column(name = "facult_id")
    public Integer getFacultId() {
        return facultId;
    }

    public void setFacultId(Integer facultId) {
        this.facultId = facultId;
    }
*/


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecialityEntity that = (SpecialityEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @ManyToOne
    @JoinColumn(name = "facult_id", referencedColumnName = "id", nullable = false)
    public FacultetEntity getFacultetEntity() {
        return faculty;
    }

    public void setFacultetEntity(FacultetEntity faculty) {
        this.faculty = faculty;
    }

}
