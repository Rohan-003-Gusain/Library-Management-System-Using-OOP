# Library Management System (Using OOP)

## Objective

A simple **Library Management System (Using OOP)** implemented in Java using **Object-Oriented Programming (OOP)**. The system allows you to manage books, users, and borrowing/returning of books through a console-based interface.

---

## Tools

- **Language:** Java
- **IDE:** VS Code

---

## Features

- View all books with available and total copies.
- Display registered users and their borrowed books count.
- Register new users with unique numeric User ID and Name.
- Issue a book to a user after validating User ID, Name, and book availability.
- Return a borrowed book with validation of User ID and Book ID.
- Show borrowed books for each user, displaying Book ID - and title.
- Simple command-line interface (CLI) menu for user operations.
- Input validation for numeric User ID and Book ID, preventing duplicates.

---

## Input Validation

- Ensures User ID and Book ID are numeric.
- Provides warnings for invalid input.
- Prevents duplicate User IDs.

## How to run

1. Compile all Java files:
```bash
    javac LibraryManagementSystem/*.java
```
2. Run the main program:
```bash
    java LibraryManagementSystem.Library
```
3. Follow the menu to perform operations:
```text
<--- Library Managements System (Using OOP) --->
Select an option to perform task.
1. Show all books
2. Show all users
3. Create new user
4. Issue book
5. Return book
6. Show borrowed books
7. Exit
Enter your choice---: 1
<--- Library Books --->
1 | Java Programming | James Gosling | Available: 5/5
2 | Python Crash Course | Eric Matthes | Available: 5/5
3 | C++ Primer | Stanley Lippman | Available: 5/5
4 | Clean Code | Robert C. Martin | Available: 5/5
5 | Data Structures and Algorithms | Narasimha Karumanchi | Available: 5/5
6 | Database System Concepts | Abraham Silberschatz | Available: 5/5
7 | Operating System Concepts | Abraham Silberschatz | Available: 5/5
-----------------------------------------
```
