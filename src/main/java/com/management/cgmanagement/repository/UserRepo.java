package com.management.cgmanagement.repository;

import com.management.cgmanagement.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

}
