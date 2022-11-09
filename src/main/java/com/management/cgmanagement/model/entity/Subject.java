package com.management.cgmanagement.model.entity;

import com.management.cgmanagement.model.Course;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    private String subjectName;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Subject() {
    }

    public Subject(String subjectName, Course course) {
        this.subjectName = subjectName;
        this.course = course;
    }

    public Subject(long id, String subjectName, Course course) {
        this.id = id;
        this.subjectName = subjectName;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
