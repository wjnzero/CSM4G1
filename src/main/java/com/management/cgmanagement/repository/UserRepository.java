package com.management.cgmanagement.repository;

import com.management.cgmanagement.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserById(Long id);
    Optional<User> findByFullName(String name);

    Page<User> findAllByFullName(String Name, Pageable pageable);

    Optional<User> findByEmail(String mail);
}
