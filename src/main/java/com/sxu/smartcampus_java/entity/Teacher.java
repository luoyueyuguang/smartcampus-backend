package com.sxu.smartcampus_java.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Teachers", schema = "smartcampus")
public class Teacher {
    @Id
    @Column(name = "teacher_id", nullable = false)
    private String teacher_id;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String name;

    @Column
    private String college;

    // Getters and Setters
    public String getTeacherId() {
        return teacher_id;
    }

    public void setTeacherId(String teacherId) {
        this.teacher_id = teacherId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teachers = (Teacher) o;
        return teacher_id.equals(teachers.teacher_id);
    }

    @Override
    public int hashCode() {
        return teacher_id.hashCode();
    }

    @Override
    public String toString() {
        return "Teachers{" +
                "teacherId='" + teacher_id + '\'' +
                ", password='" + password + '\'' +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", college='" + college + '\'' +
                '}';
    }

    public Teacher() {
    }
}

