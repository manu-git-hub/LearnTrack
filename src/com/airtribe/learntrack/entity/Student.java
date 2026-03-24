package com.airtribe.learntrack.entity;

public class Student extends Person {
    private String batch;
    private boolean active;

    // Constructor Overloading: Full parameters
    public Student(int id, String firstName, String lastName, String email, String batch, boolean active) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = true;
    }

    //Constructor Overloading: No email provided
    public Student(int id, String firstName, String lastName, String batch) {
        super(id, firstName, lastName, "No Email provided");
        this.batch = batch;
        this.active = true;
    }

    // Polymorphism: Method overriding to customize the display name for a Student
    public String getDisplayName() {
        return "Student: " + super.getDisplayName() + " (Batch " + batch + ")";
    }
}
