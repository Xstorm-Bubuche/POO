package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String studentID;
    private List<Integer> grades = new ArrayList<>();

    public Student(String name, int age, String studentID) {
        super(name, age);
        this.studentID = studentID;
    }

    public String getStudentID() { return studentID; }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getAverageGrade() {
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }
}
