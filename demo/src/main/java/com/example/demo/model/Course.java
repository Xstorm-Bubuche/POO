package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private String courseCode;
    private int creditHours;
    private List<Student> students = new ArrayList<>();

    public Course(String courseName, String courseCode, int creditHours) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
    }

    public String getCourseName() { return courseName; }
    public String getCourseCode() { return courseCode; }
    public int getCreditHours() { return creditHours; }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public List<Student> getEnrolledStudents() {
        return students;
    }
}
