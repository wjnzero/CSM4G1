package com.management.cgmanagement.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "story")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    private LocalDate date;
    @NotEmpty
    private String content;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassRoom classRoom;

    public Story() {
    }

    public Story(long id, LocalDate date, String content, ClassRoom aClass) {
        this.id = id;
        this.date = date;
        this.content = content;
        this.classRoom = aClass;
    }

    public Story(LocalDate date, String content, ClassRoom aClass) {
        this.date = date;
        this.content = content;
        this.classRoom = aClass;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ClassRoom getaClass() {
        return classRoom;
    }

    public void setaClass(ClassRoom aClass) {
        this.classRoom = aClass;
    }
}
