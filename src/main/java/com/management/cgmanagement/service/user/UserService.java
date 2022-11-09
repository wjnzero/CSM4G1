package com.management.cgmanagement.service.user;

import com.management.cgmanagement.model.entity.User;
import com.management.cgmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
    userRepository.deleteById(id);
    }
}
