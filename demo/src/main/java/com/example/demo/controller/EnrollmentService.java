package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.Enrollment;
import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentService {
    private List<Enrollment> enrollments = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    @PostMapping("/students")
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "Étudiant ajouté : " + student.getName();
    }

    @PostMapping("/courses")
    public String addCourse(@RequestBody Course course) {
        courses.add(course);
        return "Cours ajouté : " + course.getCourseName();
    }

    @PostMapping
    public String enrollStudent(@RequestParam String studentID, @RequestParam String courseCode) {
        Student student = students.stream()
                .filter(s -> s.getStudentID().equals(studentID))
                .findFirst()
                .orElse(null);

        Course course = courses.stream()
                .filter(c -> c.getCourseCode().equals(courseCode))
                .findFirst()
                .orElse(null);

        if (student == null) return "Étudiant non trouvé.";
        if (course == null) return "Cours non trouvé.";

        enrollments.add(new Enrollment(student, course));
        return student.getName() + " inscrit dans " + course.getCourseName();
    }

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollments;
    }
}
