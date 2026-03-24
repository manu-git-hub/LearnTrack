package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(String firstName, String lastName, String email, String batch) {
        int id = IdGenerator.getNextStudentId();
        Student newStudent = new Student(id, firstName, lastName, email, batch, true);
        studentRepository.addStudent(newStudent);
        System.out.println("Student" + "(" + newStudent.getFirstName() + " " + newStudent.getLastName() + ")" + " added successfully with ID: " + id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(int id) throws EntityNotFoundException {
        Student student = studentRepository.getStudentById(id);
        if (student == null) {
            throw new EntityNotFoundException("Student not found with ID: " + id);
        }
        return student;
    }

    public void deactivateStudent(int id) throws EntityNotFoundException {
        Student student = getStudentById(id);
        student.setActive(false);
        System.out.println("Student" + "(" + student.getFirstName() + " " + student.getLastName() + ")" + "ID " + id + " has been deactivated.");
    }
}

