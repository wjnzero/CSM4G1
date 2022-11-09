package com.management.cgmanagement.controller;

import com.management.cgmanagement.model.entity.Subject;
import com.management.cgmanagement.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;
    @GetMapping
    public ResponseEntity<Iterable<Subject>>findAllSubject(){
        List<Subject> subjects = List<Subject>subjectService.findAll();
        if (subjects.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(subjects,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Subject> findById(@PathVariable Long id){
        Optional<Subject> subject =subjectService.findById(id);
        if (!subject.isPresent()){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(subject.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Subject> save(@RequestBody Subject subject){
        return new ResponseEntity<>(subjectService.save(subject), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Long id,@RequestBody Subject subject){
        Optional<Subject> subject1 = subjectService.findById(id);
        if (!subject1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        subject.setId(subject1.get().getId());
        return new ResponseEntity<>(subjectService.save(subject),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Subject> deleteSubject(@PathVariable Long id){
        Optional<Subject> subject = subjectService.findById(id);
        if (!subject.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        subjectService.remove(id);
        return new ResponseEntity<>(subject.get(),HttpStatus.OK);
    }

//    @GetMapping("/show/{id}")
//    public ResponseEntity<List<Subject>> showSubject(@PathVariable Long id){
//        List<Subject> subjects = subjectService.getSubject(id);
//        if (subjects.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        subjectService.remove(id);
//        return new ResponseEntity<>(subjects,HttpStatus.OK);
//    }
}
