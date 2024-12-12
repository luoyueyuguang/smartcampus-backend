package com.sxu.smartcampus_java.entity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "Score", schema = "smartcampus")
public class Score {
    @EmbeddedId
    private ScoreId id;

    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @MapsId("course_id")
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column
    private BigDecimal result;

    // Getters and Setters

    @Embeddable
    public static class ScoreId {
        private String student_id;
        private String course_id;

        // Getters, Setters, hashCode, equals

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ScoreId scoreId = (ScoreId) o;
            return student_id.equals(scoreId.student_id) &&
                    course_id.equals(scoreId.course_id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(student_id, course_id);
        }

        public String getStudentId() {
            return student_id;
        }

        public void setStudentId(String studentId) {
            this.student_id = studentId;
        }

        public String getCourseId() {
            return course_id;
        }

        public void setCourseId(String courseId) {
            this.course_id = courseId;
        }
    }

    public ScoreId getId() {
        return id;
    }

    public void setId(ScoreId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return id.equals(score.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                ", result=" + result +
                '}';
    }

    public Score() {
    }
}

