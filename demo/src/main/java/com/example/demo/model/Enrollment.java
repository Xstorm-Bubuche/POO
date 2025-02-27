package com.example.demo.model;

public class Enrollment {
    private Student student;
    private Course course;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        course.enrollStudent(student);
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
}
