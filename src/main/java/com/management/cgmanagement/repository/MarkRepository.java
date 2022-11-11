package com.management.cgmanagement.repository;

import com.management.cgmanagement.model.dto.IMark;
import com.management.cgmanagement.model.entity.Course;
import com.management.cgmanagement.model.entity.Mark;
import com.management.cgmanagement.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MarkRepository extends JpaRepository<Mark,Long> {
    @Query(nativeQuery = true ,value = "select full_name,lecture,tutorial from users join mark on `users`.`id` = `mark`.`user_id`;")
    Iterable<IMark> getMarkNative();
}
