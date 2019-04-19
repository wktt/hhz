package com.hhz.springboot.controller;

import com.hhz.springboot.bean.Student;
import com.hhz.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudents")
    public List<Student> getStudents(){
        return this.studentService.getAllStudent();
    }
}
