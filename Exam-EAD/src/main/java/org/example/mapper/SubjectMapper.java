package org.example.mapper;

import org.example.dto.SubjectDTO;
import org.example.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectMapper {
    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);

    SubjectDTO toDTO(Subject subject);

    Subject toEntity(SubjectDTO subjectDTO);
}
