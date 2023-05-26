package com.sahil.RedisDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sahil.RedisDemo.service.StudentService;

@RestController
@RequestMapping("/redis")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<?> createStudent(){
        return studentService.createStudent();
    }

    @PostMapping("/create/multiple")
    public ResponseEntity<?> createMultiple(){
        return studentService.createMultipleStudents();
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateStudent(){
        return studentService.updateStudent();
    }

    @GetMapping("/retrieve")
    public ResponseEntity<?> retrieveStudent(){
        return studentService.retrieveStudent();
    }
}