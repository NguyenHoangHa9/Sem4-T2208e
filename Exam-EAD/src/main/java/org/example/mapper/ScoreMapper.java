package org.example.mapper;

import org.example.dto.ScoreDTO;
import org.example.entity.Score;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScoreMapper {
    ScoreMapper INSTANCE = Mappers.getMapper(ScoreMapper.class);

    ScoreDTO toDTO(Score score);

    Score toEntity(ScoreDTO scoreDTO);
}
