package com.management.cgmanagement.service.classroom;

import com.management.cgmanagement.model.entity.ClassRoom;
import com.management.cgmanagement.repository.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassRoomService implements IClassRoomService {
    @Autowired
    ClassRoomRepository classRoomRepository;
    @Override
    public Iterable<ClassRoom> findAll() {
        return classRoomRepository.findAll();
    }

    @Override
    public Optional<ClassRoom> findById(Long id) {
        return classRoomRepository.findById(id);
    }

    @Override
    public ClassRoom save(ClassRoom classRoom) {
        return classRoomRepository.save(classRoom);
    }

    @Override
    public void remove(Long id) {
        classRoomRepository.deleteById(id);
    }
}
