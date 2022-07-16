package com.stajproject.staj.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity

@Table(name = "Machinery")
public class Machinery implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(name = "machinery_name", nullable = false)
    private String machineryName;
    @Column( nullable = false)
    private String description;

    public Machinery(String machineryName, String description) {
        this.machineryName = machineryName;
        this.description = description;
    }




    public Machinery() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMachineryName() {
        return machineryName;
    }

    public void setMachineryName(String machineryName) {
        this.machineryName = machineryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
