package com.netcracker.etalon.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "facultet", schema = "navr", catalog = "")
public class FacultetEntity {
    private int id;
    private String name;
    private List<SpecialityEntity> specialityEntities;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultetEntity that = (FacultetEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
/*    @OneToMany
    @JoinColumn(name = "id", referencedColumnName = "facult_id", nullable = false)
    public List<SpecialityEntity> getSpecialityEntities() {
        return specialityEntities;
    }

    public void setSpecialityEntities(List<SpecialityEntity> specialityEntities) {
        this.specialityEntities = specialityEntities;
    }*/
}
