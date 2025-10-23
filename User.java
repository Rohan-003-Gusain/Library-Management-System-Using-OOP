package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String name;
    private List<Book> borrowedBooks;
    
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.removeIf(b -> b.getBookId() == book.getBookId());
    }

    public void showBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " has no books borrowed.");
        } else { 
            System.out.println(name + " has borrowed: ");
            for (Book b : borrowedBooks) {
                System.out.println("BookID : " + b.getBookId() + " - " + b.getTitle());
            }
            
        }  
    }
    @Override
    public String toString() {
        return "User [Id= " + userId + ", name= " + name +", BorrowedBooks= " + borrowedBooks.size() + "]";
    }
    
}
