package com.sxu.smartcampus_java.controller;

import com.sxu.smartcampus_java.entity.Score;
import com.sxu.smartcampus_java.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/{studentId}/{courseId}")
    public ResponseEntity<Score> getScoreById(@PathVariable String studentId, @PathVariable String courseId) {
        Score score = scoreService.findById(studentId, courseId);
        return ResponseEntity.ok(score);
    }

    @GetMapping
    public ResponseEntity<List<Score>> getAllScores() {
        return ResponseEntity.ok(scoreService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createScore(@RequestBody Score score) {
        scoreService.createScore(score);
        return ResponseEntity.ok("Score created successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateScore(@RequestBody Score score) {
        scoreService.updateScore(score);
        return ResponseEntity.ok("Score updated successfully");
    }

    @DeleteMapping("/{studentId}/{courseId}")
    public ResponseEntity<String> deleteScore(@PathVariable String studentId, @PathVariable String courseId) {
        scoreService.deleteScore(studentId, courseId);
        return ResponseEntity.ok("Score deleted successfully");
    }
}

