package com.management.cgmanagement.service.tuition;

import com.management.cgmanagement.model.entity.Tuition;
import com.management.cgmanagement.repository.ITuitionRepository;
import com.management.cgmanagement.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TuitionService implements ITuitionService {

    @Autowired
    private ITuitionRepository tuitionRepository;

    @Override
    public Iterable<Tuition> findAll() {
        return tuitionRepository.findAll();
    }

    @Override
    public Optional<Tuition> findById(Long id) {
        return tuitionRepository.findById(id);
    }



    @Override
    public Tuition save(Tuition tuition) {
        return tuitionRepository.save(tuition);
    }

    @Override
    public void remove(Long id) {
        tuitionRepository.deleteById(id);
    }
}
