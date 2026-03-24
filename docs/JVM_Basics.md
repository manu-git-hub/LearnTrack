# JVM Basics

**What are JDK, JRE, and JVM?**
* **JDK (Java Development Kit):** The full toolkit we use to write Java, containing the compiler (`javac`) and other tools. 
* **JRE (Java Runtime Environment):** Provides the libraries needed to run Java programs. 
* **JVM (Java Virtual Machine):** The engine inside the JRE that actually executes the code line by line.

**What is bytecode and "Write Once, Run Anywhere"?**
When we compile a Java program, it is not translated directly into machine code for a specific OS (like Windows or Mac). Instead, it is translated into an intermediate format called **bytecode** (`.class` files). The JVM on any operating system can read this bytecode and translate it into machine-specific instructions on the fly. This means we can write and compile our Java code once, and it will run anywhere a JVM is installed.