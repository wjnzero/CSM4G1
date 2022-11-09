package com.management.cgmanagement.service.mark;

import com.management.cgmanagement.model.entity.Mark;
import com.management.cgmanagement.repository.MarkRepo;
import com.management.cgmanagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MarkService implements IMarkService{

    @Autowired
    MarkRepo markRepo;
    @Autowired
    UserRepo userRepo;

    @Override
    public Iterable<Mark> findAll() {
        return markRepo.findAll();
    }

    @Override
    public Optional<Mark> findById(Long id) {
        return markRepo.findById(id);
    }

    @Override
    public Mark save(Mark mark) {
        return markRepo.save(mark);
    }

    @Override
    public void remove(Long id) {
        markRepo.deleteById(id);
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
