package com.management.cgmanagement.service.subject;

import com.management.cgmanagement.model.entity.Subject;
import com.management.cgmanagement.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SubjectService implements ISubjectService{
    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public Iterable<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> findById(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void remove(Long id) {
    subjectRepository.deleteById(id);
    }
//    public List<Subject> getSubject(Long id){
//        return studentRepository.findById(id).get().getSubject();
//    }
}
