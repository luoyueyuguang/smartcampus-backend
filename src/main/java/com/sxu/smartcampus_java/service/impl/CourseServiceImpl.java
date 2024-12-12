package com.sxu.smartcampus_java.service.impl;

import com.sxu.smartcampus_java.entity.Course;
import com.sxu.smartcampus_java.mapper.CourseMapper;
import com.sxu.smartcampus_java.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Course findById(String courseId) {
        return courseMapper.findById(courseId);
    }

    @Override
    public List<Course> findAll() {
        return courseMapper.findAll();
    }

    @Override
    public void createCourse(Course course) {
        if (courseMapper.findById(course.getCourseId()) != null) {
            throw new RuntimeException("Course already exists with ID: " + course.getCourseId());
        }
        courseMapper.insert(course);
    }

    @Override
    public void updateCourse(Course course) {
        if (courseMapper.findById(course.getCourseId()) == null) {
            throw new RuntimeException("Course not found with ID: " + course.getCourseId());
        }
        courseMapper.update(course);
    }

    @Override
    public void deleteCourse(String courseId) {
        if (courseMapper.findById(courseId) == null) {
            throw new RuntimeException("Course not found with ID: " + courseId);
        }
        courseMapper.delete(courseId);
    }
}

