package com.management.cgmanagement.repository;

import com.management.cgmanagement.model.entity.Subject;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SubjectRepository extends PagingAndSortingRepository<Subject,Long> {
}
