package com.management.cgmanagement.service.classroom;

import com.management.cgmanagement.model.entity.ClassRoom;
<<<<<<< HEAD
import com.management.cgmanagement.repository.ClassRoomRepository;
=======
import com.management.cgmanagement.repository.ClassRepository;
>>>>>>> model
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
<<<<<<< HEAD
public class ClassRoomService implements IClassRoomService {
    @Autowired
    ClassRoomRepository classRoomRepository;
    @Override
    public Iterable<ClassRoom> findAll() {
        return classRoomRepository.findAll();
=======
public class ClassRoomService implements  IClassRoomService{
    @Autowired
    private ClassRepository classRepository;

    @Override
    public Iterable<ClassRoom> findAll() {
        return classRepository.findAll();
>>>>>>> model
    }

    @Override
    public Optional<ClassRoom> findById(Long id) {
<<<<<<< HEAD
        return classRoomRepository.findById(id);
=======
        return classRepository.findById(id);
>>>>>>> model
    }

    @Override
    public ClassRoom save(ClassRoom classRoom) {
<<<<<<< HEAD
        return classRoomRepository.save(classRoom);
=======
        return classRepository.save(classRoom);
>>>>>>> model
    }

    @Override
    public void remove(Long id) {
<<<<<<< HEAD
        classRoomRepository.deleteById(id);
=======
        classRepository.deleteById(id);
>>>>>>> model
    }
}
