package org.example.controller;

import org.example.dto.ScoreDTO;
import org.example.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @PostMapping
    public void addScore(@RequestBody ScoreDTO scoreDTO) {
        scoreService.addScore(scoreDTO);
    }

    @GetMapping("/student/{studentId}")
    public List<ScoreDTO> getScoresByStudentId(@PathVariable int studentId) {
        return scoreService.getScoresByStudentId(studentId);
    }
}
