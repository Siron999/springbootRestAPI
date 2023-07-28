package com.example.sprinbootdemo.controller;

import com.example.sprinbootdemo.model.Student;
import com.example.sprinbootdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("student")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        this.studentService.createStudent(student);
        return ResponseEntity.status(201).body("Student Created Successfully");
    }

    @GetMapping("student")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = this.studentService.getAllStudents();
        return ResponseEntity.status(200).body(students);
    }

    @GetMapping("student/{id}")
    public ResponseEntity<Student> getAllStudents(@PathVariable("id") int id) {
        Student student = this.studentService.getStudentById(id);
        return ResponseEntity.status(200).body(student);
    }

    @PutMapping("student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        Student savedStudent = this.studentService.updateStudent(student, id);
        return ResponseEntity.status(200).body(savedStudent);
    }

    @DeleteMapping("student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
        this.studentService.deleteStudentById(id);
        return ResponseEntity.status(200).body("Student Deleted");
    }
}
