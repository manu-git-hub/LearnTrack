package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    //List to store students
    private List<Student> students = new ArrayList<>();

    //Method to add a student
    public void addStudent(Student student) {
        students.add(student);
    }

    //Method to get all students
    public List<Student> getAllStudents() {
        return students;
    }

    //Method to get a student by ID
    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
