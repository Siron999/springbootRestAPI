package com.example.sprinbootdemo.service;

import com.example.sprinbootdemo.model.Student;

import java.util.List;

public interface StudentService {
    void createStudent(Student student);

    Student getStudentById(int id);

    List<Student> getAllStudents();

    void deleteStudentById(int id);

    Student updateStudent(Student student, int id);

}
