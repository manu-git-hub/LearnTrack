package com.airtribe.learntrack.entity;

public class Student extends Person {
    private int batch;
    private boolean active;

    // Constructor Overloading: Full parameters
    public Student(int id, String firstName, String lastName, String email, int batch, boolean active) {
        super(id, firstName, lastName, email);
        this.batch = 2023;
        this.active = true;
    }

    // Polymorphism: Method overriding to customize the display name for a Student
    @Override
    public String getDisplayName() {
        return "Student: " + super.getDisplayName() + " (Batch " + batch + ")";
    }
}
