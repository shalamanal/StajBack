package com.stajproject.staj.model;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@RequiredArgsConstructor
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long orderId;
    @Column(nullable = false)
    private String order_place;
    @Column(nullable = false)
    private Date order_date;
    @ManyToOne
    @JoinColumn(name = "users", referencedColumnName = "id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "service", referencedColumnName = "id")
    private Service service;

    @OneToOne
    @JoinColumn(name = "state", referencedColumnName = "id")
    private State state;

    @ManyToOne
    @JoinColumn(name = "machinery", referencedColumnName = "id")
    private Machinery machinery;

    public Long getOrderId() {
        return orderId;
    }



    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrder_place() {
        return order_place;
    }

    public void setOrder_place(String order_place) {
        this.order_place = order_place;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Machinery getMachinery() {
        return machinery;
    }

    public void setMachinery(Machinery machinery) {
        this.machinery = machinery;
    }


}
