# Design Notes

## Why ArrayList instead of Arrays?

We chose `ArrayList` for our repository layers (e.g., `StudentRepository`) because dynamic resizing is crucial for this
application. Standard Java arrays have a fixed size upon creation. If we used an array with a size of 10, we could only
ever store 10 students. `ArrayList` handles dynamic resizing automatically under the hood, allowing us to add and remove
students, courses, and enrollments infinitely without worrying about capacity limits or writing complex array-copying
logic.

## Use of Static Members

We used static members primarily in the `IdGenerator` utility class (e.g., `private static int studentIdCounter`).
Because these variables are static, they belong to the class itself rather than any specific object instance. This
ensures that every time we call `IdGenerator.getNextStudentId()`, we are incrementing one global, shared counter,
guaranteeing that every new entity receives a unique, sequential ID. We also used static constants in `MenuOptions` to
avoid magic numbers.

## Use of Inheritance

We utilized inheritance by creating a base `Person` class and having `Student` extend it (
`public class Student extends Person`).

* **What we gained:** This prevented code duplication. Both students and potential future entities (like Teachers or
  Admins) share common attributes like `id`, `firstName`, `lastName`, and `email`. By putting these in `Person`, the
  `Student` class only needed to define attributes specific to a student (like `batch` and `active` status). It also
  allowed us to practice method overriding with the `getDisplayName()` method.