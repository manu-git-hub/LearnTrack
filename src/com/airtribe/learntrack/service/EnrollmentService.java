package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.List;

public class EnrollmentService {
    private EnrollmentRepository enrollmentRepository;
    private StudentService studentService;
    private CourseService courseService;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, StudentService studentService, CourseService courseService) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public void enrollStudent(int studentId, int courseId) throws EntityNotFoundException {
        // Validate that both student and course exist
        studentService.getStudentById(studentId);
        courseService.getCourseById(courseId);

        int id = IdGenerator.getNextEnrollmentId();
        Enrollment newEnrollment = new Enrollment(id, studentId, courseId, LocalDate.now(), EnrollmentStatus.ACTIVE);
        enrollmentRepository.addEnrollment(newEnrollment);

        System.out.println("Student ID " + studentId + " successfully enrolled in Course ID " + courseId + ". Enrollment ID: " + id);
    }

    public List<Enrollment> getEnrollmentsForStudent(int studentId) throws EntityNotFoundException {
        // Ensure student exists first
        studentService.getStudentById(studentId);
        return enrollmentRepository.getEnrollmentsByStudentId(studentId);
    }

    public void updateEnrollmentStatus(int enrollmentId, EnrollmentStatus newStatus) throws EntityNotFoundException {
        Enrollment enrollment = enrollmentRepository.getEnrollmentById(enrollmentId);
        if (enrollment == null) {
            throw new EntityNotFoundException("Enrollment not found with ID: " + enrollmentId);
        }
        enrollment.setStatus(newStatus);
        System.out.println("Enrollment ID " + enrollmentId + " status updated to " + newStatus);
    }
}