# LearnTrack — TODO

## Project Summary
LearnTrack is a console-based Student & Course Management System (Core Java). Practice OOP, collections, simple exception handling, and clean code.

## TODO (tracked)

1. Add docs
	- [✅] Create `docs/Setup_Instructions.md` (JDK version, hello-world run)
	- [✅] Create `docs/JVM_Basics.md` (JDK/JRE/JVM, bytecode, WORA)

2. Package structure
	- [✅] Ensure base package `com.airtribe.learntrack` with subpackages: `entity`, `service`, `ui`, `exception`, `util`, `docs`

3. Entities & inheritance
	- [✅] Implement `Person` (id, firstName, lastName, email)
	- [✅] Implement `Student` extends `Person` (id, firstName, lastName, email, batch, active) with constructor overloading
	- [✅] Optional: `Trainer` extends `Person`
	- [ ] Implement `Course` (id, courseName, description, durationInWeeks, active)
	- [ ] Implement `Enrollment` (id, studentId, courseId, enrollmentDate, status)

4. Utilities
	- [ ] `util/IdGenerator` (static id counters/getNext methods)
	- [ ] `util/InputValidator` (basic input checks)

5. Services
	- [ ] `service/StudentService` (add, update, deactivate, find, list)
	- [ ] `service/CourseService` (add, activate/deactivate, find, list)
	- [ ] `service/EnrollmentService` (enroll, listByStudent, updateStatus)

6. Exceptions & validation
	- [ ] `exception/EntityNotFoundException`
	- [ ] `exception/InvalidInputException`
	- [ ] Use try/catch for input parsing and service calls

7. Console UI
	- [ ] `ui/Main.java` menu: Student, Course, Enrollment management loops and input handling
	- [ ] Keep UI focused on display/input; delegate logic to services

8. Documentation & README
	- [ ] `README.md` with project description, compile/run steps, class diagram link
	- [ ] `docs/Design_Notes.md` (why ArrayList, where static used, inheritance notes)

9. Tests & sample runs
	- [ ] Add simple run script or sample flows demonstrating core features

10. Submission prep
	- [ ] Format code, quick compile check, push to GitHub, open PR (public repo)

---

Progress: created tracked TODO. Next: add `docs/Setup_Instructions.md` and `docs/JVM_Basics.md`.

