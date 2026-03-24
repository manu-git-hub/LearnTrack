package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.EnrollmentStatus;

import java.time.LocalDate;

public class Enrollment {

    private int id;
    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;
    private EnrollmentStatus status; //"ACTIVE", "COMPLETED", "CANCELLED"

    // Parameterized constructor
    public Enrollment(int id, int studentId, int courseId, LocalDate enrollmentDate, EnrollmentStatus status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = LocalDate.now();
        this.status = status;
    }

    //Public Getters
    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    //Public Setters
    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }

    public String toString() {
        return "Enrollment [id=" + id + ", studentId=" + studentId + ", courseId=" + courseId + ", enrollmentDate=" + enrollmentDate + ", status=" + status + "]";
    }
}
