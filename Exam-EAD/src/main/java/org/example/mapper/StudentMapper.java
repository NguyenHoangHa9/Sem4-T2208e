package org.example.mapper;

import org.example.dto.StudentDTO;
import org.example.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO toDTO(Student student);

    Student toEntity(StudentDTO studentDTO);
}
