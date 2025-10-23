package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books;
    private List<User> users;
    private static Scanner sc = new Scanner(System.in);

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    private Book findBook(int bookId) {
        for (Book b : books) {
            if (b.getBookId() == bookId) return b;
        }
        return null;
    }

    private User findUser(int userId) {
        for (User u : users) {
            if (u.getUserId() == userId) return u;
        }
        return null;
    }

    private int getIntInput(String prompt) {
        System.out.println(prompt);
        if (!sc.hasNextInt()) {
            System.out.println("Warning: Invalid User Id! Please enter a number.");
            sc.nextLine();
            return -1;
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    public User createUser() {
        int userId = getIntInput("Enter user ID: ");
        if (userId == -1) {
            return null;
        }

        User user = findUser(userId);
        if (user != null) {
            System.out.println("Error: User Id already exists with name: " + user.getName());
            return null;
        }

        System.out.println("Enter user Name: ");
        String name = sc.nextLine();

        User newUser = new User(userId, name);
        addUser(newUser);
        System.out.println("New user regitsered: " + name);
        return newUser;
    }

    public void issueBook() {
        int userId = getIntInput("Enter user ID: ");
        if (userId == -1) {
            return;
        }

        System.out.println("Enter User Name: ");
        String name = sc.nextLine();

        int bookId = getIntInput("Enter book ID: ");
        if (bookId == -1) {
            return;
        }
        
        Book book = findBook(bookId);

        if (book == null) {
            System.err.println("Book not found!");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("no copies available for " + book.getTitle());
            return;
        }

        User user = findUser(userId);
        if (user == null) {
            System.out.println("Error: User ID not found! Please register first. ");
            return;
        }

        if (!user.getName().equals(name)) {
            System.out.println("Error: Name is incorrect!");
            return;
        }

        book.issue();
        user.borrowBook(book);
        System.out.println("Book \"" + book.getTitle() + "\" issued to " + user.getName());
        
    }

    public void returnBook() {
        int userId = getIntInput("Enter user ID: ");
        if (userId == -1) {
            return;
        }

        int bookId = getIntInput("Enter book ID: ");
        if (bookId == -1) {
            return;
        }
        
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book == null || user == null) {
            System.out.println("Book or User not found!");
            return;
        }

        if (user.getBorrowedBooks().contains(book)) {
            book.returnBook();
            user.returnBook(book);
            System.out.println("Book \"" + book.getTitle() + "\" returned successfully by " + user.getName());
        }
    }

    public void showAllBooks() {
        System.out.println("<--- Library Books --->");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void showAllUsers() {
        System.out.println("<--- Registerd User --->");
        for (User u : users) {
            System.out.println(u);
        }
    }

    public void showBorrowedBooks() {
        System.out.println("<--- Borrowed Books --->");
        for (User u : users) {
            u.showBorrowedBooks();
        }
    }

    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book(1, "Java Programming", "James Gosling", 5));
        library.addBook(new Book(2, "Python Crash Course", "Eric Matthes", 5));
        library.addBook(new Book(3, "C++ Primer", "Stanley Lippman", 5));
        library.addBook(new Book(4, "Clean Code", "Robert C. Martin", 5));
        library.addBook(new Book(5, "Data Structures and Algorithms", "Narasimha Karumanchi", 5));
        library.addBook(new Book(6, "Database System Concepts", "Abraham Silberschatz", 5));
        library.addBook(new Book(7, "Operating System Concepts", "Abraham Silberschatz", 5));


        boolean exit = false;

        System.out.println("<--- Library Managements System (Using OOP) --->");

        while (!exit) {
            System.out.println("Select an option to perfomr task.");
            System.out.println("1. Show all books");
            System.out.println("2. Show all users");
            System.out.println("3. Create new user");
            System.out.println("4. Issue book");
            System.out.println("5. Return book");
            System.out.println("6. Show borrowed books");
            System.out.println("7. Exit");

            System.out.print("Enter your choice---: ");

            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1: 
                        library.showAllBooks();
                        break;

                    case 2: 
                        library.showAllUsers();
                        break;

                    case 3: 
                        library.createUser();
                        break;

                    case 4: 
                        library.issueBook();
                        break;

                    case 5:
                        library.returnBook();
                        break;

                    case 6:
                        library.showBorrowedBooks();
                        break;

                    case 7:
                        System.out.println("Exiting from the System");
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid choice, Please select a valid choice!");
                        break;
                    }
                    System.out.println("-----------------------------------------");
            } else {
                System.out.println("Invalid Input, Please select a valid choice!");
                sc.nextLine();
                continue;
            }

        }
    }

}