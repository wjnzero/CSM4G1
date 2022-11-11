package com.management.cgmanagement.controller.admin;


import com.management.cgmanagement.model.entity.Course;
import com.management.cgmanagement.model.entity.Role;
import com.management.cgmanagement.model.entity.User;
import com.management.cgmanagement.service.course.ICourseService;
import com.management.cgmanagement.service.jwt.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin
public class AdminController {
    @Autowired
    TokenService tokenService;

    @Autowired
    ICourseService courseService;

    @PostMapping("/create-course")
    public ResponseEntity<Course> register(@RequestBody Course course){
        return new ResponseEntity<>(courseService.save(course), HttpStatus.OK);
    }

}
