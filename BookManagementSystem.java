import java.util.Scanner;

class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getBookID() {
        return bookID;
    }

    public void displayInfo() {
        System.out.println("BookID: " + bookID + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable);
    }
}

class Library {
    private Book[] books;
    private int count;

    public Library() {
        books = new Book[5];
        count = 0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Library is full! Cannot add more books.");
        }
    }

    // Now Remove Book method
    public void removeBook(int bookID) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (books[i].getBookID() == bookID) {
                // Shift remaining books to the left
                for (int j = i; j < count - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[count - 1] = null;
                count--;
                found = true;
                System.out.println("Book removed successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found!");
        }
    }

    public Book searchBook(int bookID) {
        for (int i = 0; i < count; i++) {
            if (books[i].getBookID() == bookID) {
                return books[i];
            }
        }
        return null;
    }

    public void displayBooks() {
        if (count == 0) {
            System.out.println("No books in the library!");
            return;
        }
        for (int i = 0; i < count; i++) {
            books[i].displayInfo();
        }
    }
}

public class BookManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;
        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    Book newBook = new Book(id, title, author);
                    library.addBook(newBook);
                    break;
                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = sc.nextInt();
                    library.removeBook(removeId);
                    break;
                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchId = sc.nextInt();
                    Book foundBook = library.searchBook(searchId);
                    if (foundBook != null) {
                        System.out.println("Book found:");
                        foundBook.displayInfo();
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
