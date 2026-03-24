# LearnTrack - Student & Course Management System

## 1. Project Summary
LearnTrack is a console-based **Student & Course Management System** built using Core Java.

It allows admins to manage:
- Students
- Courses
- Enrollments

### Goal
This project focuses on practicing:
- Java basics (variables, data types, control flow)
- Classes, objects, constructors
- Static vs instance members
- OOP principles (encapsulation, inheritance, polymorphism)
- Collections (ArrayList)
- Basic exception handling
- Clean and modular code design

> Note: This project avoids advanced topics like concurrency and streams to focus on fundamentals.

---

## 2. Learning Objectives

### Java Setup & Execution
- Understand JDK vs JRE vs JVM
- Compile and run Java programs
- Use IDE or terminal

### Core Java Basics
- Packages and classes
- Data types (primitive vs reference)
- Variable scope (local, instance, static)
- Typecasting basics

### OOP Fundamentals
- Classes and objects
- Constructors (default & parameterized)
- Constructor overloading
- Encapsulation (private fields + getters/setters)
- Inheritance & method overriding
- Basic polymorphism

### Logic & Control Flow
- if/else, switch
- Loops: for, while, do-while
- Menu-driven console apps

### Collections
- Array vs ArrayList
- Using ArrayList for dynamic storage

### Exception Handling
- try-catch blocks
- Handling invalid input

### Clean Code
- Small, reusable methods
- Meaningful naming
- Separation of concerns

---

## 3. Project Requirements

### A. Environment Setup & JVM (10 Marks)
- Install Java (JDK)
- Create:
  - `docs/Setup_Instructions.md`
  - `docs/JVM_Basics.md`

#### JVM Basics should include:
- What is JDK, JRE, JVM
- What is bytecode
- "Write once, run anywhere"

---

### B. Package Structure (10 Marks)

#### Key Points:
- Use proper access modifiers
- Use static variables where needed (e.g., ID counters)

---

### C. Core OOP Implementation (40 Marks)

#### 1. Entities (15 Marks)

**Student**
- id, firstName, lastName, email, batch, active

**Course**
- id, courseName, description, durationInWeeks, active

**Enrollment**
- id, studentId, courseId, enrollmentDate, status

#### Requirements:
- Private fields + getters/setters
- Constructors
- Constructor overloading

---

#### 2. Inheritance & Polymorphism (10 Marks)

**Base Class: Person**
- id, firstName, lastName, email

**Derived Classes:**
- Student extends Person
- (Optional) Trainer extends Person

#### Concepts:
- `super` keyword
- Method overriding (e.g., `getDisplayName()`)

---

#### 3. Static & Utility (15 Marks)

**IdGenerator**
- Static counters
- Methods:
  - `getNextStudentId()`
  - `getNextCourseId()`

**Service Methods**
- addStudent
- removeStudent
- updateStudent
- listStudents

---

### D. Console UI (25 Marks)

Menu-driven application in `Main.java`.

#### Features:

**Student Management**
- Add student
- View students
- Search by ID
- Deactivate student

**Course Management**
- Add course
- View courses
- Activate/Deactivate

**Enrollment Management**
- Enroll student
- View enrollments
- Update status

#### Implementation:
- Use `ArrayList`
- In-memory data only
- Separate logic into service layer
- Handle invalid inputs

---

### E. Exception Handling (10 Marks)

- Create custom exception:
  - `EntityNotFoundException`
- Use try-catch for:
  - Invalid input
  - Missing entities

---

### F. Documentation & Clean Code (5 Marks)

#### Include:
- `README.md`
- `docs/Design_Notes.md`

#### Design Notes Should Explain:
- Why ArrayList over arrays
- Use of static members
- Use of inheritance

#### Clean Code Practices:
- Small methods
- Clear naming
- Modular structure

---

## 4. How to Compile & Run

```bash
# Compile
javac com/airtribe/learntrack/ui/Main.java

# Run
java com.airtribe.learntrack.ui.Main