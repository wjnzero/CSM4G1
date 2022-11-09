package com.management.cgmanagement.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "teacher" ,uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@NoArgsConstructor
//@Getter
//@Setter
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTeacher;
    @NotNull
    private String fullName;
    @NaturalId
    @NotNull
    private String email;
    @JsonIgnore
    @NotNull
    private String password;
    private Long phoneNumber;
    private String address;
    private LocalDate dateOfBirth;
    private String identity;
    private String status;
}
