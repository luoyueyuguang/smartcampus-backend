package com.sxu.smartcampus_java.service;

import com.sxu.smartcampus_java.entity.Score;

import java.util.List;

public interface ScoreService {
    Score findById(String studentId, String courseId);

    List<Score> findAll();

    void createScore(Score score);

    void updateScore(Score score);

    void deleteScore(String studentId, String courseId);
}

