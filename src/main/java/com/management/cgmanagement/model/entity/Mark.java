package com.management.cgmanagement.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "mark")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long markId;
    //Điểm lý thuyết
    private Double lecture;
    //Điểm thực hành
    private Double tutorial;
    // Giáo vụ
    @OneToMany
    @JoinColumn(name = "userId",referencedColumnName = "markId")
    private User academicStaff;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "userId",referencedColumnName = "markId")
//    private Student studentId;
}
