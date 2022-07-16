package com.stajproject.staj.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity

@Table(name = "Service")
public class Service  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String price;

    public Service(String name, String price) {
        this.name = name;
        this.price = price;
    }



    public Service() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
