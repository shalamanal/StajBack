package com.stajproject.staj.Security.Pojo;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer ";
    private Long id;
    private String nickname;
    private String picture;
    private List<String> roles;

    public JwtResponse(String token, Long id, String nickname, String picture, List<String> roles) {
        this.token = type + token;
        this.id = id;
        this.nickname = nickname;
        this.picture = picture;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
