package com.management.cgmanagement.controller.mark;

import com.management.cgmanagement.model.entity.Mark;
import com.management.cgmanagement.service.mark.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/mark")
public class MarkController {
    @Autowired
    MarkService markService;

    @PostMapping
    public ResponseEntity<Mark> save(@RequestBody Mark mark){
        return new ResponseEntity<>(markService.save(mark), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Mark> updateCourse(@PathVariable Long id,@RequestBody Mark mark){
        Optional<Mark> mark1 = markService.findById(id);
        if (!mark1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        mark.setId(mark1.get().getId());
        return new ResponseEntity<>(markService.save(mark),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Mark> deleteCourse(@PathVariable Long id){
        Optional<Mark> mark = markService.findById(id);
        if (!mark.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        markService.remove(id);
        return new ResponseEntity<>(mark.get(),HttpStatus.OK);
    }
}
