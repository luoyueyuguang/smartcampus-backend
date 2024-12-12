package com.sxu.smartcampus_java.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Students", schema = "smartcampus")
public class Student {
    @Id
    @Column(name = "student_id", nullable = false)
    private String student_id;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "class")
    private String clazz;

    @Column
    private Integer grade;

    @Column
    private String college;

    @Column
    private String major;

    // Getters and Setters
    public String getStudentId() {
        return student_id;
    }

    public void setStudentId(String studentId) {
        this.student_id = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return student_id.equals(student.student_id);
    }

    @Override
    public int hashCode() {
        return student_id.hashCode();
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentId='" + student_id + '\'' +
                ", password='" + password + '\'' +
                ", user=" + user +
                ", class='" + clazz + '\'' +
                ", grade=" + grade +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                '}';
    }

    public Student() {
    }
}

