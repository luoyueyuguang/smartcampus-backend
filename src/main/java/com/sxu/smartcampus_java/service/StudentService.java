package com.sxu.smartcampus_java.service;

import com.sxu.smartcampus_java.entity.Student;

import java.util.List;

public interface StudentService {
    Student findById(String studentId);

    List<Student> findAll();

    void createStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(String studentId);
}

