import java.util.ArrayList;

abstract class User {
    private String name;

    User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract void displayRole();
}

class Student extends User {

    Student(String name) {
        super(name);
    }

    @Override
    void displayRole() {
        System.out.println("Role: Student");
    }
}

class Book {
    private String title;
    private String author;
    private boolean available;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrowBook() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }

    public void displayBook() {
        System.out.println(title + " by " + author +
                " - " + (available ? "Available" : "Borrowed"));
    }
}

class Library {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book Added: " + book.getTitle());
    }

    public void borrowBook(String title) {

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {

                if (book.isAvailable()) {
                    book.borrowBook();
                    System.out.println("Book Borrowed: " + title);
                } else {
                    System.out.println("Book Already Borrowed");
                }

                return;
            }
        }

        System.out.println("Book Not Found");
    }

    public void returnBook(String title) {

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                System.out.println("Book Returned: " + title);
                return;
            }
        }

        System.out.println("Book Not Found");
    }

    public void displayBooks() {

        System.out.println("\nLibrary Books:");

        for (Book book : books) {
            book.displayBook();
        }
    }
}

public class LibraryManagement {

    public static void main(String[] args) {

        System.out.println("===== LIBRARY MANAGEMENT SYSTEM =====");

        Library library = new Library();

        Student student = new Student("Vedika");

        System.out.println("\nUser Name: " + student.getName());
        student.displayRole();

        Book book1 = new Book("Java Programming", "James Gosling");
        Book book2 = new Book("Python Basics", "Guido van Rossum");

        System.out.println();

        library.addBook(book1);
        library.addBook(book2);

        library.displayBooks();

        System.out.println("\n--- Borrow Book ---");
        library.borrowBook("Java Programming");

        library.displayBooks();

        System.out.println("\n--- Return Book ---");
        library.returnBook("Java Programming");

        library.displayBooks();

        System.out.println("\n===== PROGRAM END =====");
    }
}