package com.management.cgmanagement.service.classroom;

import com.management.cgmanagement.model.entity.ClassRoom;
import com.management.cgmanagement.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassRoomService implements  IClassRoomService{
    @Autowired
    private ClassRepository classRepository;

    @Override
    public Iterable<ClassRoom> findAll() {
        return classRepository.findAll();
    }

    @Override
    public Optional<ClassRoom> findById(Long id) {
        return classRepository.findById(id);
    }

    @Override
    public ClassRoom save(ClassRoom classRoom) {
        return classRepository.save(classRoom);
    }

    @Override
    public void remove(Long id) {
        classRepository.deleteById(id);
    }
}
