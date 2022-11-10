package com.management.cgmanagement.repository;

import com.management.cgmanagement.model.entity.Course;
import com.management.cgmanagement.model.entity.Mark;
import com.management.cgmanagement.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarkRepository extends JpaRepository<Mark,Long> {
}
