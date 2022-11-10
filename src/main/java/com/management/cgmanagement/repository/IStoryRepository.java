package com.management.cgmanagement.repository;

import com.management.cgmanagement.model.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStoryRepository extends JpaRepository<Story, Long> {
}
