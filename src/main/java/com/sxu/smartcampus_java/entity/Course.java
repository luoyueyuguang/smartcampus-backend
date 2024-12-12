package com.sxu.smartcampus_java.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Courses", schema = "smartcampus")
public class Course {
    @Id
    @Column(nullable = false,name = "course_id")
    private String course_id;

    @Column(nullable = false,name = "course_name")
    private String course_name;

    @Column
    private Integer credits;

    @Column
    private String classroom;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    // Getters and Setters
    public String getCourseId() {
        return course_id;
    }

    public void setCourseId(String courseId) {
        this.course_id = courseId;
    }

    public String getCourseName() {
        return course_name;
    }

    public void setCourseName(String courseName) {
        this.course_name = courseName;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return course_id.equals(course.course_id);
    }

    @Override
    public int hashCode() {
        return course_id.hashCode();
    }

    @Override
    public String toString() {
        return "Courses{" +
                "courseId='" + course_id + '\'' +
                ", courseName='" + course_name + '\'' +
                ", credits=" + credits +
                ", classroom='" + classroom + '\'' +
                ", teacher=" + teacher +
                '}';
    }

    public Course() {
    }
}
