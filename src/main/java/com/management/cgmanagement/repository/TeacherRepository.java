package com.management.cgmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    Teacher findTeacherByIdTeacher (Long id);

}
