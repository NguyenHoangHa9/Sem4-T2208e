package org.example.service;

import org.example.dto.StudentDTO;
import org.example.entity.Student;
import org.example.mapper.StudentMapper;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    private final StudentMapper studentMapper = StudentMapper.INSTANCE;

    public void addStudent(StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        studentRepository.save(student);
    }

    public StudentDTO getStudent(int studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        return studentMapper.toDTO(student);
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }
}
