package com.management.cgmanagement.repository;


import com.management.cgmanagement.model.Tuition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITuitionRepository extends JpaRepository<Tuition, Long> {
}
