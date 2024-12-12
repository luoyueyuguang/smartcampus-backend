package com.sxu.smartcampus_java.service.impl;

import com.sxu.smartcampus_java.entity.Score;
import com.sxu.smartcampus_java.mapper.ScoreMapper;
import com.sxu.smartcampus_java.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public Score findById(String studentId, String courseId) {
        return scoreMapper.findById(studentId, courseId);
    }

    @Override
    public List<Score> findAll() {
        return scoreMapper.findAll();
    }

    @Override
    public void createScore(Score score) {
        if (scoreMapper.findById(score.getId().getStudentId(), score.getId().getCourseId()) != null) {
            throw new RuntimeException("Score already exists for student ID: " + score.getId().getStudentId() +
                    " and course ID: " + score.getId().getCourseId());
        }
        scoreMapper.insert(score);
    }

    @Override
    public void updateScore(Score score) {
        if (scoreMapper.findById(score.getId().getStudentId(), score.getId().getCourseId()) == null) {
            throw new RuntimeException("Score not found for student ID: " + score.getId().getStudentId() +
                    " and course ID: " + score.getId().getCourseId());
        }
        scoreMapper.update(score);
    }

    @Override
    public void deleteScore(String studentId, String courseId) {
        if (scoreMapper.findById(studentId, courseId) == null) {
            throw new RuntimeException("Score not found for student ID: " + studentId +
                    " and course ID: " + courseId);
        }
        scoreMapper.delete(studentId, courseId);
    }
}

