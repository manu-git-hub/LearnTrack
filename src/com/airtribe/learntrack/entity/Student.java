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

    //Public Getters
    public String getBatch() {
        return batch;
    }

    public boolean isActive() {
        return active;
    }

    //Public Setters
    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // Polymorphism: Method overriding to customize the display name for a Student
    public String getDisplayName() {
        return "Student: " + super.getDisplayName() + " (Batch " + batch + ")";
    }

    public String toString() {
        return "Student [id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", email=" + getEmail() + ", batch=" + batch + ", active=" + active + "]";
    }
}
