package org.example.service;

import org.example.dto.ScoreDTO;
import org.example.entity.Score;
import org.example.mapper.ScoreMapper;
import org.example.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    private final ScoreMapper scoreMapper = ScoreMapper.INSTANCE;

    public void addScore(ScoreDTO scoreDTO) {
        Score score = scoreMapper.toEntity(scoreDTO);
        scoreRepository.save(score);
    }

    public List<ScoreDTO> getScoresByStudentId(int studentId) {
        return scoreRepository.findByStudentStudentId(studentId).stream()
                .map(scoreMapper::toDTO)
                .collect(Collectors.toList());
    }

}
