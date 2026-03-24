package com.airtribe.learntrack.entity;

import java.time.LocalDate;

public class Enrollment {

    private int id;
    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;
    private String status; //"ACTIVE", "COMPLETED", "CANCELLED"

    // Parameterized constructor
    public Enrollment(int id, int studentId, int courseId) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = LocalDate.now();
        this.status = "ACTIVE";
    }
}
