package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.CourseStatus;

public class Course {

    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private CourseStatus status;

    // Parameterized constructor
    public Course(int id, String courseName, String description, int durationInWeeks, CourseStatus status) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.status = status;
    }

    //Public Getters
    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public CourseStatus getStatus() {
        return status;
    }

    //Public Setters
    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    //Method to display course details
    @Override
    public String toString() {
        return "Course [id=" + id + ", courseName=" + courseName + ", description=" + description + ", durationInWeeks=" + durationInWeeks + ", active=" + status + "]";
    }
}
