package com.example.mysecurity.controller;

import com.example.mysecurity.module.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    static private List<Student> studentList = Arrays.asList(new Student[]{
            new Student(1, "张三"),
            new Student(2, "李四"),
            new Student(3, "王五")
    });

    @RequestMapping("{studentId}")
    public Student getStudent(@PathVariable(name = "studentId") Integer studentId) {
        return studentList.stream().
                filter(student -> student.getStudentId().equals(studentId)).
                findFirst().
                orElseThrow(() -> new IllegalArgumentException("该用户不存在"));
    }
}
