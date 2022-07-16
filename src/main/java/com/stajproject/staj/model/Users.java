package com.stajproject.staj.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity

@Table(name = "Users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nickname;
    @Column(nullable = false)
    private String picture;
    @Column(nullable = false)
    private String password;


  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles",
              joinColumns = @JoinColumn(name = "user_id"),
              inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();


    public void setId(Long id) {
        this.id = id;
    }

    public Users() {}
    public Users(String nickname, String picture, String password){
        this.nickname = nickname;
        this.picture = picture;
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


 public Set<Role> getRoles() {
     return roles;
 }

 public void setRoles(Set<Role> roles) {
     this.roles = roles;
 }



    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
