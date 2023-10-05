import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean available;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() {
        if (available) {
            available = false;
        } else {
            System.out.println("Sorry, the book is already borrowed.");
        }
    }

    public void returnBook() {
        available = true;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + "\nTitle: " + title + "\nAuthor: " + author + "\nAvailable: " + (available ? "Yes" : "No");
    }
}

class Library {
    private Map<String, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void borrowBook(String isbn) {
        Book book = books.get(isbn);
        if (book != null) {
            book.borrow();
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }

    public void returnBook(String isbn) {
        Book book = books.get(isbn);
        if (book != null) {
            book.returnBook();
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }

    public List<Book> listAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
}

public class LibraryManagementSystem1 {
    public static void main(String[] args) {
        Library library = new Library();

        // Add some books to the library
        library.addBook(new Book("12345", "Book 1", "Author 1"));
        library.addBook(new Book("67890", "Book 2", "Author 2"));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. List Available Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    List<Book> availableBooks = library.listAvailableBooks();
                    if (availableBooks.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        System.out.println("Available Books:");
                        for (Book book : availableBooks) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter ISBN of the book to borrow: ");
                    String borrowIsbn = scanner.next();
                    library.borrowBook(borrowIsbn);
                    break;
                case 3:
                    System.out.print("Enter ISBN of the book to return: ");
                    String returnIsbn = scanner.next();
                    library.returnBook(returnIsbn);
                    break;
                case 4:
                    System.out.println("Exiting the Library Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
    }
}
