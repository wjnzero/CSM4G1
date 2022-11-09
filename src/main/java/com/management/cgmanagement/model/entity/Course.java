package com.management.cgmanagement.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseID;
    @NotEmpty
    private String courseName;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Course() {
    }

    public Course(Long courseID, String courseName, Student student) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.student = student;
    }

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
