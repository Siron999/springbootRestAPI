package com.example.sprinbootdemo.service.impl;

import com.example.sprinbootdemo.model.Student;
import com.example.sprinbootdemo.repository.StudentRepository;
import com.example.sprinbootdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public void createStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        Optional<Student> student = this.studentRepository.findById(id);
        if (student.isEmpty()) throw new RuntimeException("Student not found");
        return student.get();
    }

    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public void deleteStudentById(int id) {
        this.studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Student student, int id) {
        Student savedStudent = this.getStudentById(id);

        if (Objects.nonNull(student.getName())) {
            savedStudent.setName(student.getName());
        }

        if (Objects.nonNull(student.getAddress())) {
            savedStudent.setAddress(student.getAddress());
        }

        return this.studentRepository.save(savedStudent);
    }
}
