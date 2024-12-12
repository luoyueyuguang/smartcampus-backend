package com.sxu.smartcampus_java.controller;

import com.sxu.smartcampus_java.entity.Teacher;
import com.sxu.smartcampus_java.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/{teacherId}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable String teacherId) {
        Teacher teacher = teacherService.findById(teacherId);
        return ResponseEntity.ok(teacher);
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createTeacher(@RequestBody Teacher teacher) {
        teacherService.createTeacher(teacher);
        return ResponseEntity.ok("Teacher created successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateTeacher(@RequestBody Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return ResponseEntity.ok("Teacher updated successfully");
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<String> deleteTeacher(@PathVariable String teacherId) {
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.ok("Teacher deleted successfully");
    }
}

