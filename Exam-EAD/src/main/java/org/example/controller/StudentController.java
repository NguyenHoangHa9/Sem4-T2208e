package org.example.controller;

import org.example.dto.StudentDTO;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public void addStudent(@RequestBody StudentDTO studentDTO) {
        studentService.addStudent(studentDTO);
    }

    @GetMapping("/{studentId}")
    public StudentDTO getStudent(@PathVariable int studentId) {
        return studentService.getStudent(studentId);
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }
}
