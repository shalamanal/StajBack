package com.stajproject.staj.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity

@Table(name = "State")
public class State implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(name = "state_name", nullable = false)
    private String stateName;

    public State(String stateName) {
        this.stateName = stateName;
    }



    public State() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
