package com.example.demo.model;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
// import com.example.demo.model.Enrollment;
// import com.example.demo.model.Student;
// import com.example.demo.model.Course;


@Service
public class EnrollmentService {
    private List<Enrollment> enrollments = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public String addStudent(Student student) {
        students.add(student);
        return "Étudiant ajouté : " + student.getName();
    }

    public String addCourse(Course course) {
        courses.add(course);
        return "Cours ajouté : " + course.getCourseName();
    }

    public String enrollStudent(String studentID, String courseCode) {
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

    public List<Enrollment> getAllEnrollments() {
        return enrollments;
    }
}
