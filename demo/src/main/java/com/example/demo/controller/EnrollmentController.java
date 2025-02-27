package com.example.demo.controller;

import com.example.demo.model.EnrollmentService;
import com.example.demo.model.Student;
import com.example.demo.model.Course;
import com.example.demo.model.Enrollment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @RestController
@RequestMapping("/api")
public class TestController {
    
    @GetMapping("/students")
    public String addStudent(@RequestBody Student student) {
        return enrollmentService.addStudent(student);
    }

    @PostMapping("/courses")
    public String addCourse(@RequestBody Course course) {
        return enrollmentService.addCourse(course);
    }

    @PostMapping
    public String enrollStudent(@RequestParam String studentID, @RequestParam String courseCode) {
        return enrollmentService.enrollStudent(studentID, courseCode);
    }

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    
    @GetMapping("/home")
    public String hello() {
        return "tkt ca marche";
    }


    // @PostMapping("/students")
    // public String addStudent(@RequestBody Student student) {
    //     return enrollmentService.addStudent(student);
    // }

    // @PostMapping("/courses")
    // public String addCourse(@RequestBody Course course) {
    //     return enrollmentService.addCourse(course);
    // }

    // @PostMapping
    // public String enrollStudent(@RequestParam String studentID, @RequestParam String courseCode) {
    //     return enrollmentService.enrollStudent(studentID, courseCode);
    // }

    // @GetMapping
    // public List<Enrollment> getAllEnrollments() {
    //     return enrollmentService.getAllEnrollments();
    // }
    
}
}
