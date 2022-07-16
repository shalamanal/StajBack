package com.stajproject.staj.Security.Pojo;

import java.util.Set;

public class SignupRequest {

    private String nickname;
    private String picture;
    private Set<String> roles;
    private String password;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Set<String> getRole() {
        return roles;
    }

    public void setRole(Set<String> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
