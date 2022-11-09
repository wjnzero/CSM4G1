package com.management.cgmanagement.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "classes")
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String nameClass;
    @NotEmpty
    private String numberStudent;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public ClassRoom() {
    }

    public ClassRoom(String name, String nameClass, String numberStudent, User user) {
        this.name = name;
        this.nameClass = nameClass;
        this.numberStudent = numberStudent;
        this.user = user;
    }

    public ClassRoom(Long id, String name, String nameClass, String numberStudent, User user) {
        this.id = id;
        this.name = name;
        this.nameClass = nameClass;
        this.numberStudent = numberStudent;
        this.user = user;
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

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getNumberStudent() {
        return numberStudent;
    }

    public void setNumberStudent(String numberStudent) {
        this.numberStudent = numberStudent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
