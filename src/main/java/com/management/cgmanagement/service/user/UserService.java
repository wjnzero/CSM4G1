package com.management.cgmanagement.service.user;

import com.management.cgmanagement.model.entity.User;

import java.util.Optional;

public class UserService implements IUserService{


    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
