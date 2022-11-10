package com.management.cgmanagement.controller.tuition;


import com.management.cgmanagement.model.entity.Course;
import com.management.cgmanagement.model.entity.Tuition;
import com.management.cgmanagement.model.entity.Tuition;
import com.management.cgmanagement.model.entity.User;
import com.management.cgmanagement.service.course.CourseService;
import com.management.cgmanagement.service.tuition.TuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/tuition")
public class TuitionController {
    @Autowired
    private TuitionService tuitionService;
@Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<Iterable<Tuition>> findAllTuition(){
        List<Tuition> tuition = (List<Tuition>)tuitionService.findAll();
        if (tuition.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tuition,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tuition> findById(@PathVariable Long id){
        Optional<Tuition> tuitions =tuitionService.findById(id);
        if (!tuitions.isPresent()){
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tuitions.get(),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Tuition> save(@RequestBody Tuition tuition){
        Tuition temp = new Tuition();
        temp.setId(tuition.getId());

        Long courseid = (tuition.getCourse()).getId();

        Course course = courseService.findById(courseid).get();
        temp.setCourse(course);
        temp.setTotalFee(tuition.getTotalFee());
        temp.setCompletedFee(tuition.getCompletedFee());


        return new ResponseEntity<>(tuitionService.save(temp), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Tuition> updateTuition(@PathVariable Long id,@RequestBody Tuition tuition){
        Optional<Tuition> tuitionOptional = tuitionService.findById(id);
        if (!tuitionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tuition.setId(tuitionOptional.get().getId());
        return new ResponseEntity<>(tuitionService.save(tuition),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tuition> deleteTuition(@PathVariable Long id){
        Optional<Tuition> tuitionOptional = tuitionService.findById(id);
        if (!tuitionOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tuitionService.remove(id);
        return new ResponseEntity<>(tuitionOptional.get(),HttpStatus.OK);
    }

}