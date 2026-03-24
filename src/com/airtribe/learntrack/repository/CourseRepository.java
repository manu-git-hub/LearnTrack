package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    //List to store courses
    private List<Course> courses = new ArrayList<>();

    //Method to add a Course
    public void addCourse(Course course) {
        courses.add(course);
    }

    //Method to get all Courses
    public List<Course> getAllCourses() {
        return courses;
    }

    //Method to get a Course by ID
    public Course getCourseById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }
}
