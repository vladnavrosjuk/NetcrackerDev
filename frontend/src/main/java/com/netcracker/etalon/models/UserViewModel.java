package com.netcracker.etalon.models;

import com.netcracker.etalon.security.impl.CustomUser;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserViewModel extends CustomUser{
    private String id;
    private String login;
    private String passuser;
    private String role;

    public UserViewModel(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassuser() {
        return passuser;
    }

    public void setPassuser(String passuser) {
        this.passuser = passuser;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
