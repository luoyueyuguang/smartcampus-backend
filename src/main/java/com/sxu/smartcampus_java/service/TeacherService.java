package com.sxu.smartcampus_java.service;

import com.sxu.smartcampus_java.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher findById(String teacherId);

    List<Teacher> findAll();

    void createTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    void deleteTeacher(String teacherId);
}

