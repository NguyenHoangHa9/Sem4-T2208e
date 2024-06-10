package org.aptech.t2208e.controller;

import org.aptech.t2208e.dto.StudentDto;
import org.aptech.t2208e.entity.Student;
import org.aptech.t2208e.service.StudentService;
import org.aptech.t2208e.service.impl.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    StudentService studentService = new StudentServiceImpl();
    // api/v1/student/1  .. and httpMethod  = GET
    @GetMapping(value = "/student/{studentId}")
    public StudentDto get(@PathVariable Long studentId){
        return studentService.getById(studentId);
    }
    @GetMapping(value = "/students")
    public List<StudentDto> findAll(){
        return studentService.findAll();
    }
    @PostMapping(value = "/student/{firstName}")
    public List<StudentDto>SearchByFirstName(@RequestParam String firstName) {
        List<StudentDto> students = studentService.findByFirstName(firstName);
        return studentService.findByFirstName(firstName);
    }
    @PostMapping
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(studentService.addStudent(studentDto));
    }

}
