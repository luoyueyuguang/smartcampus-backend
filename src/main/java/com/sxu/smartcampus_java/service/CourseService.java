package com.sxu.smartcampus_java.service;

import com.sxu.smartcampus_java.entity.Course;

import java.util.List;

public interface CourseService {
    Course findById(String courseId);

    List<Course> findAll();

    void createCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(String courseId);
}
