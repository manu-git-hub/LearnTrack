import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    // Initialize Repositories
    private static StudentRepository studentRepo = new StudentRepository();
    private static CourseRepository courseRepo = new CourseRepository();
    private static EnrollmentRepository enrollmentRepo = new EnrollmentRepository();

    // Initialize Services
    private static StudentService studentService = new StudentService(studentRepo);
    private static CourseService courseService = new CourseService(courseRepo);
    private static EnrollmentService enrollmentService = new EnrollmentService(enrollmentRepo, studentService, courseService);

    public static void main(String[] args) {
        System.out.println(AppConstants.DIVIDER);
        System.out.println("Welcome to " + AppConstants.APP_NAME);
        System.out.println(AppConstants.DIVIDER);

        boolean running = true;
        while (running) {
            System.out.println("\nMAIN MENU:");
            System.out.println(MenuOptions.MAIN_MANAGE_STUDENTS + ". Manage Students");
            System.out.println(MenuOptions.MAIN_MANAGE_COURSES + ". Manage Courses");
            System.out.println(MenuOptions.MAIN_MANAGE_ENROLLMENTS + ". Manage Enrollments");
            System.out.println(MenuOptions.MAIN_EXIT + ". Exit");
            System.out.println(AppConstants.DIVIDER);
            System.out.print("Select an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case MenuOptions.MAIN_MANAGE_STUDENTS:
                        handleStudentMenu();
                        break;
                    case MenuOptions.MAIN_MANAGE_COURSES:
                        handleCourseMenu();
                        break;
                    case MenuOptions.MAIN_MANAGE_ENROLLMENTS:
                        handleEnrollmentMenu();
                        break;
                    case MenuOptions.MAIN_EXIT:
                        running = false;
                        System.out.println("Exiting application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the bad input
            }
        }
        scanner.close();
    }

    private static void handleStudentMenu() {
        System.out.println("\n--- Student Management ---");
        System.out.println(MenuOptions.STUDENT_ADD + ". Add Student");
        System.out.println(MenuOptions.STUDENT_VIEW_ALL + ". View All Students");
        System.out.println(MenuOptions.STUDENT_SEARCH + ". Search Student by ID");
        System.out.println(MenuOptions.STUDENT_DEACTIVATE + ". Deactivate Student");
        System.out.print("Select an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (choice) {
                case MenuOptions.STUDENT_ADD:
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Batch: ");
                    String batch = scanner.nextLine();
                    studentService.addStudent(firstName, lastName, email, batch);
                    break;
                case MenuOptions.STUDENT_VIEW_ALL:
                    List<Student> students = studentService.getAllStudents();
                    if (students.isEmpty()) System.out.println("No students found.");
                    for (Student s : students) System.out.println(s);
                    break;
                case MenuOptions.STUDENT_SEARCH:
                    System.out.print("Enter Student ID: ");
                    int searchId = scanner.nextInt();
                    System.out.println(studentService.getStudentById(searchId));
                    break;
                case MenuOptions.STUDENT_DEACTIVATE:
                    System.out.print("Enter Student ID to deactivate: ");
                    int deactivateId = scanner.nextInt();
                    studentService.deactivateStudent(deactivateId);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static void handleCourseMenu() {
        System.out.println("\n--- Course Management ---");
        System.out.println(MenuOptions.COURSE_ADD + ". Add Course");
        System.out.println(MenuOptions.COURSE_VIEW_ALL + ". View All Courses");
        System.out.println(MenuOptions.COURSE_TOGGLE_STATUS + ". Toggle Course Status");
        System.out.print("Select an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (choice) {
                case MenuOptions.COURSE_ADD:
                    System.out.print("Course Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Duration (in weeks): ");
                    int duration = scanner.nextInt();
                    courseService.addCourse(name, desc, duration);
                    break;
                case MenuOptions.COURSE_VIEW_ALL:
                    List<Course> courses = courseService.getAllCourses();
                    if (courses.isEmpty()) System.out.println("No courses found.");
                    for (Course c : courses) System.out.println(c);
                    break;
                case MenuOptions.COURSE_TOGGLE_STATUS:
                    System.out.print("Enter Course ID to toggle status: ");
                    int courseId = scanner.nextInt();
                    courseService.toggleCourseStatus(courseId);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void handleEnrollmentMenu() {
        System.out.println("\n--- Enrollment Management ---");
        System.out.println(MenuOptions.ENROLL_STUDENT + ". Enroll Student in Course");
        System.out.println(MenuOptions.ENROLL_VIEW_FOR_STUDENT + ". View Enrollments for Student");
        System.out.println(MenuOptions.ENROLL_UPDATE_STATUS + ". Update Enrollment Status");
        System.out.print("Select an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (choice) {
                case MenuOptions.ENROLL_STUDENT:
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Enter Course ID: ");
                    int courseId = scanner.nextInt();
                    enrollmentService.enrollStudent(studentId, courseId);
                    break;
                case MenuOptions.ENROLL_VIEW_FOR_STUDENT:
                    System.out.print("Enter Student ID: ");
                    int searchStudentId = scanner.nextInt();
                    List<Enrollment> enrollments = enrollmentService.getEnrollmentsForStudent(searchStudentId);
                    if (enrollments.isEmpty()) System.out.println("No enrollments found for this student.");
                    for (Enrollment e : enrollments) System.out.println(e);
                    break;
                case MenuOptions.ENROLL_UPDATE_STATUS:
                    System.out.print("Enter Enrollment ID: ");
                    int enrollId = scanner.nextInt();
                    System.out.println("Select New Status (1=ACTIVE, 2=COMPLETED, 3=CANCELLED): ");
                    int statusChoice = scanner.nextInt();
                    EnrollmentStatus newStatus = EnrollmentStatus.ACTIVE;
                    if (statusChoice == 2) newStatus = EnrollmentStatus.COMPLETED;
                    if (statusChoice == 3) newStatus = EnrollmentStatus.CANCELLED;

                    enrollmentService.updateEnrollmentStatus(enrollId, newStatus);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}