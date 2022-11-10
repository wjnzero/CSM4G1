package com.management.cgmanagement.service.mark;

import com.management.cgmanagement.model.entity.Mark;
import com.management.cgmanagement.repository.MarkRepository;
import com.management.cgmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class MarkService implements IMarkService{

    @Autowired
    MarkRepository markRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<Mark> findAll() {
        return markRepository.findAll();
    }

    @Override
    public Optional<Mark> findById(Long id) {
        return markRepository.findById(id);
    }

    @Override
    public Mark save(Mark mark) {
        return markRepository.save(mark);
    }

    @Override
    public void remove(Long id) {
        markRepository.deleteById(id);
    }
//    public List<Mark> getMark(Long id){
//        return userRepo.findById(id).get().get
//    }

//    @Override
//    public Optional<Mark> findMarkByLecture(Double lecture) {
//        return markRepo.findMarkByLecture(lecture);
//    }
//
//    @Override
//    public Optional<Mark> findMarkByTutorial(Double tutorial) {
//        return markRepo.findMarkByTutorial(tutorial);
//    }
}
