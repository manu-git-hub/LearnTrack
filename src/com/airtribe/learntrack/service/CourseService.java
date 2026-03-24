package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.enums.CourseStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void addCourse(String courseName, String description, int durationInWeeks) {
        int id = IdGenerator.getNextCourseId();
        Course newCourse = new Course(id, courseName, description, durationInWeeks, CourseStatus.ACTIVE);
        courseRepository.addCourse(newCourse);
        System.out.println("Course added successfully with ID: " + id);
    }

    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    public Course getCourseById(int id) throws EntityNotFoundException {
        Course course = courseRepository.getCourseById(id);
        if (course == null) {
            throw new EntityNotFoundException("Course not found with ID: " + id);
        }
        return course;
    }

    public void toggleCourseStatus(int id) throws EntityNotFoundException {
        Course course = getCourseById(id);
        if (course.getStatus() == CourseStatus.ACTIVE) {
            course.setStatus(CourseStatus.INACTIVE);
            System.out.println("Course ID " + id + " is now INACTIVE.");
        } else {
            course.setStatus(CourseStatus.ACTIVE);
            System.out.println("Course ID " + id + " is now ACTIVE.");
        }
    }
}