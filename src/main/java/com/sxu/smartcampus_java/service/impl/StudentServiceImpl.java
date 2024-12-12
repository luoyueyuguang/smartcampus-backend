package com.sxu.smartcampus_java.service.impl;

import com.sxu.smartcampus_java.entity.Student;
import com.sxu.smartcampus_java.mapper.StudentMapper;
import com.sxu.smartcampus_java.service.StudentService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student findById(String studentId) {
        return studentMapper.findById(studentId);
    }

    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public void createStudent(Student student) {
        if (studentMapper.findById(student.getStudentId()) != null) {
            throw new RuntimeException("Student already exists with ID: " + student.getStudentId());
        }
        studentMapper.insert(student);
    }

    @Override
    public void updateStudent(Student student) {
        if (studentMapper.findById(student.getStudentId()) == null) {
            throw new RuntimeException("Student not found with ID: " + student.getStudentId());
        }
        studentMapper.update(student);
    }

    @Override
    public void deleteStudent(String studentId) {
        if (studentMapper.findById(studentId) == null) {
            throw new RuntimeException("Student not found with ID: " + studentId);
        }
        studentMapper.delete(studentId);
    }
}

