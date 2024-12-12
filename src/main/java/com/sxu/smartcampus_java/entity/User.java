package com.sxu.smartcampus_java.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "Users", schema = "smartcampus")
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    private String user_id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public enum Role {
        student, teacher, administrator
    }
    // Getters and Setters
    public String getUserId() {
        return user_id;
    }

    public void setUserId(String userId) {
        this.user_id = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User users = (User) o;
        return user_id.equals(users.user_id);
    }

    @Override
    public int hashCode() {
        return user_id.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + user_id + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}

