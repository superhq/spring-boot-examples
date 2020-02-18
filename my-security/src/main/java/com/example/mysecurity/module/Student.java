package com.example.mysecurity.module;

public class Student {
    private Integer studentId;
    private String studentName;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                '}';
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public Student(Integer studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }
}
