package org.aptech.t2208e.repository;

import org.aptech.t2208e.dto.StudentDto;
import org.aptech.t2208e.entity.Student;

import java.util.List;
import java.util.Optional;

public interface  StudentRepository {
    Optional<List<Student>> getById(String id);
    List<Student> getAll();
    List<Student> findByFirstName(String firstName);
    Optional<List<Student>> getByFirstName(String firstName);
    StudentDto addStudent(StudentDto studentDto);

}
