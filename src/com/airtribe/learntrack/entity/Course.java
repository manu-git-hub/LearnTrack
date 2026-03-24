package com.airtribe.learntrack.entity;

public class Course {

    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private boolean active;

    // Parameterized constructor
    public Course(int id, String courseName, String description, int durationInWeeks, boolean active) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.active = active;
    }
}
