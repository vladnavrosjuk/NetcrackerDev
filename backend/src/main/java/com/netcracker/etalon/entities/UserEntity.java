package com.netcracker.etalon.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "navr", catalog = "")
public class UserEntity {
    private int id;
    private String login;
    private String passuser;
    private StudentEntity studentEntity;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "passuser")
    public String getPassuser() {
        return passuser;
    }

    public void setPassuser(String passuser) {
        this.passuser = passuser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                Objects.equals(login, that.login) &&
                Objects.equals(passuser, that.passuser);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, passuser);
    }
    @OneToOne
    @JoinColumn (name = "student_id", referencedColumnName = "id", nullable = false)
    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }
}
