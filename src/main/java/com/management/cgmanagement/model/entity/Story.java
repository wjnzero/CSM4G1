package com.management.cgmanagement.model.entity;

import com.management.cgmanagement.model.entity.ClassRoom;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.Date;

@Entity
@Data
@Table(name = "story")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    private Date date;
    @NotEmpty
    private String content;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassRoom classRoom;

    public Story() {
    }

    public Story(long id, Date date, String content, ClassRoom classRoom) {
        this.id = id;
        this.date = date;
        this.content = content;
        this.classRoom = classRoom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Story(Date date, String content, ClassRoom classRoom) {
        this.date = date;
        this.content = content;
        this.classRoom = classRoom;

    }
}


