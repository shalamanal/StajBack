package com.stajproject.staj.Security.Pojo;

public class LoginRequest {

    private String nickname;
    private String password;

    public String getNickname() {
        return nickname;
    }

    public void setUsername(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
