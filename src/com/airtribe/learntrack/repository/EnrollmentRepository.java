package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {
    //List to store enrollments
    private List<Enrollment> enrollments = new ArrayList<>();

    //Method to add an enrollment
    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    //Method to get all enrollments
    public List<Enrollment> getAllEnrollments() {
        return enrollments;
    }

    //Method to get  Enrollment by ID
    public Enrollment getEnrollmentById(int id) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId() == id) {
                return enrollment;
            }
        }
        return null;
    }

    // Helper method to find all enrollments for a specific student
    public List<Enrollment> getEnrollmentsByStudentId(int studentId) {
        List<Enrollment> studentEnrollments = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == studentId) {
                studentEnrollments.add(enrollment);
            }
        }
        return studentEnrollments;
    }
}
