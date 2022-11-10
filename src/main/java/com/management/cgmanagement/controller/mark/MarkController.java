package com.management.cgmanagement.controller.mark;

import com.management.cgmanagement.model.entity.Course;
import com.management.cgmanagement.model.entity.Mark;
import com.management.cgmanagement.model.entity.User;
import com.management.cgmanagement.service.course.CourseService;
import com.management.cgmanagement.service.mark.MarkService;
import com.management.cgmanagement.service.user.IUserService;
import com.management.cgmanagement.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/mark")
public class MarkController {
    @Autowired
    MarkService markService;

    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;

    @GetMapping
    public ResponseEntity<Iterable<Mark>> findAllMark() {
        List<Mark> courses = (List<Mark>) markService.findAll();
        if (courses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Mark> save(@RequestBody Mark mark) {
        Mark temp = new Mark();
        temp.setId(mark.getId());

        Long userid = (mark.getUser()).getId();
        Long courseid = (mark.getCourse()).getId();

        User user = userService.findById(userid).get();
        temp.setUser(user);

        Course course = courseService.findById(courseid).get();
        temp.setCourse(course);


        return new ResponseEntity<>(markService.save(temp), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mark> updateCourse(@PathVariable Long id, @RequestBody Mark mark) {
        Optional<Mark> mark1 = markService.findById(id);
        if (!mark1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        mark.setId(mark1.get().getId());
        return new ResponseEntity<>(markService.save(mark), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mark> deleteCourse(@PathVariable Long id) {
        Optional<Mark> mark = markService.findById(id);
        if (!mark.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        markService.remove(id);
        return new ResponseEntity<>(mark.get(), HttpStatus.OK);
    }
}
