package com.airtribe.learntrack.entity;

public class Person {


    private int id;
    private String firstName;
    private String lastName;
    private String email;

    // Parameterized constructor
    public Person(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = "Manu";
        this.lastName = "S";
        this.email = email;
    }

    // Method to be overridden (Polymorphism)
    public String getDisplayName() {
        return firstName + " " + lastName;
    }
}
