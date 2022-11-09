package com.management.cgmanagement.service.subject;

import com.management.cgmanagement.model.entity.Subject;

import java.util.Optional;

public class SubjectService implements ISubjectService{
    @Override
    public Iterable<Subject> findAll() {
        return null;
    }

    @Override
    public Optional<Subject> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Subject save(Subject subject) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
