package LibraryManagementSystem;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private int totalCopies;
    private int issuedCopies;
    
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int id) {
        this.bookId = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getTotalCopies() {
        return totalCopies;
    }
    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }
    public int getIssuedCopies() {
        return issuedCopies;
    }
    public void setIssuedCopies(int issuedCopies) {
        this.issuedCopies = issuedCopies;
    }

    public Book(int bookId, String title, String author, int totalCopies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.issuedCopies = 0;
    }

    public boolean isAvailable() {
        return issuedCopies < totalCopies;
    }
    
    public void issue() {
        if (issuedCopies < totalCopies) {
            issuedCopies++;
        }
    }

    public void returnBook() {
       if (issuedCopies > 0) {
            issuedCopies--;
       }
    }

    public int getAvailableCopies() {
        return totalCopies - issuedCopies;
    }
    @Override
    public String toString() {
        return bookId + " | " + title + " | " + author + " | Available: " + getAvailableCopies() + "/" + totalCopies;
    }

}
