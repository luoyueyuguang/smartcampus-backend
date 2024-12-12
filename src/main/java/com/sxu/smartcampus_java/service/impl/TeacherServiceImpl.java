package com.sxu.smartcampus_java.service.impl;

import com.sxu.smartcampus_java.entity.Teacher;
import com.sxu.smartcampus_java.mapper.TeacherMapper;
import com.sxu.smartcampus_java.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher findById(String teacherId) {
        return teacherMapper.findById(teacherId);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherMapper.findAll();
    }

    @Override
    public void createTeacher(Teacher teacher) {
        if (teacherMapper.findById(teacher.getTeacherId()) != null) {
            throw new RuntimeException("Teacher already exists with ID: " + teacher.getTeacherId());
        }
        teacherMapper.insert(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        if (teacherMapper.findById(teacher.getTeacherId()) == null) {
            throw new RuntimeException("Teacher not found with ID: " + teacher.getTeacherId());
        }
        teacherMapper.update(teacher);
    }

    @Override
    public void deleteTeacher(String teacherId) {
        if (teacherMapper.findById(teacherId) == null) {
            throw new RuntimeException("Teacher not found with ID: " + teacherId);
        }
        teacherMapper.delete(teacherId);
    }
}
