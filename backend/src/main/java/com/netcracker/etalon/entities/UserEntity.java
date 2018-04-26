package com.netcracker.etalon.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "navr", catalog = "")
public class UserEntity {
    private int id;
    private String login;
    private String passuser;
    private String role;
    private StudentEntity studentEntity;
    private RequestEntity requestEntity;



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

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn (name = "student_id", referencedColumnName = "id", nullable = false)
    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn (name = "id_request", referencedColumnName = "id", nullable = false)

    public RequestEntity getRequestEntity() {
        return requestEntity;
    }

    public void setRequestEntity(RequestEntity requestEntity) {
        this.requestEntity = requestEntity;
    }
}
