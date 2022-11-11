package com.management.cgmanagement.repository;

import com.management.cgmanagement.model.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassRoom, Long> {
}
