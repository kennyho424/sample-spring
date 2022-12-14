package com.example.samplespring.controller;

import com.example.samplespring.model.Person;
import com.example.samplespring.model.Student;
import com.example.samplespring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public List<Student> getStudentList() {
        return studentService.getStudents();
    }
}
