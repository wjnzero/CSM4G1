package com.management.cgmanagement.repository;

import com.management.cgmanagement.model.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarkRepo extends JpaRepository<Mark,Long> {
   Optional<Mark> findMarkByLecture(Double lecture);
   Optional<Mark> findMarkByTutorial(Double tutorial);

}
