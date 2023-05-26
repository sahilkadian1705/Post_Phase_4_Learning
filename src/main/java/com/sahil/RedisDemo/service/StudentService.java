package com.sahil.RedisDemo.service;

import com.sahil.RedisDemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.sahil.RedisDemo.repository.StudentRepository;

@Service
public class StudentService{
    @Autowired
    private StudentRepository studentRepository;
    public ResponseEntity<?> createStudent(){
        Student student = new Student(
                "Eng2015001", "John Doe", Student.Gender.MALE, 1);
        studentRepository.save(student);
        return ResponseEntity.ok().body("Student created");
    }
    public ResponseEntity createMultipleStudents(){
        Student engStudent = new Student(
                "Eng2015001", "John Doe", Student.Gender.MALE, 1);
        Student medStudent = new Student(
                "Med2015001", "Gareth Houston", Student.Gender.MALE, 2);
        studentRepository.save(engStudent);
        studentRepository.save(medStudent);
        return ResponseEntity.ok().body("created");
    }


    public ResponseEntity<?> retrieveStudent(){
        Student retrievedStudent =
                studentRepository.findById("Eng2015001").get();
        return  ResponseEntity.ok().body(retrievedStudent);
    }

    public ResponseEntity<?> updateStudent(){
        Student retrievedStudent =
                studentRepository.findById("Eng2015001").get();
        retrievedStudent.setName("Richard Watson");
        studentRepository.save(retrievedStudent);
        return ResponseEntity.ok().body("updated"+ retrievedStudent);
    }
}

