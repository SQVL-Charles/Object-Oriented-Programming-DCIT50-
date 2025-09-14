import java.util.Scanner;

public class LibraryBookManagementSystem {

    // Define the maximum number of books the system can store
    private static final int MAX_BOOKS = 5;

    // Arrays to store book titles and their status
    private static String[] bookTitles = new String[MAX_BOOKS];
    private static String[] bookStatuses = new String[MAX_BOOKS];
    private static int bookCount = 0; // Counter for the number of books in the system

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayMainMenu();
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input from the scanner
                System.out.print("Enter your choice: ");
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    updateBookStatus();
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Exiting the program. Thank you for using the Library Book Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option (1-5).");
            }
            System.out.println(); // Add a blank line for better readability
        } while (choice != 5);
        scanner.close();
    }

    /**
     * Displays the main menu of the system.
     */
    private static void displayMainMenu() {
        System.out.println("=====================================");
        System.out.println("  Library Book Management System");
        System.out.println("=====================================");
        System.out.println("1. Add a New Book");
        System.out.println("2. Update Book Status");
        System.out.println("3. Show All Books");
        System.out.println("4. Generate Report");
        System.out.println("5. Exit");
        System.out.println("-------------------------------------");
    }

    /**
     * Adds a new book to the system.
     * The book is added with a default status of "Available."
     */
    private static void addBook() {
        if (bookCount >= MAX_BOOKS) {
            System.out.println("System is full. Cannot add more books.");
            return;
        }

        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();
        
           // Check if the book title already exists in the list
    for (int i = 0; i < bookCount; i++) {
        if (bookTitles[i].equalsIgnoreCase(title)) {
            System.out.println("This book title already exists. Please enter a different title.");
            return;
        }
    }
    
        bookTitles[bookCount] = title;
        bookStatuses[bookCount] = "Available";
        bookCount++;
        System.out.println("Book '" + title + "' has been successfully added.");
    }

    /**
     * Updates the status of a book (Available or Borrowed).
     * The user is prompted to enter a book number to update its status.
     */
    private static void updateBookStatus() {
    if (bookCount == 0) {
        System.out.println("No books in the system to update.");
        return;
    }

    showBooks();
    int bookNumber = readInt("Enter the book number to update (1 to " + bookCount + "): ", 1, bookCount);
    int index = bookNumber - 1;

    // Toggle the status
    bookStatuses[index] = bookStatuses[index].equals("Available") ? "Borrowed" : "Available";
    System.out.println("Book '" + bookTitles[index] + "' status updated to '" + bookStatuses[index] + "'.");
}

/**
 * Reads an integer within the given range, reprompting on invalid input.
 */
    private static int readInt(String prompt, int min, int max) {
      while (true) {
          System.out.print(prompt);
          if (scanner.hasNextInt()) {
              int value = scanner.nextInt();
              scanner.nextLine(); // consume newline
              if (value >= min && value <= max) return value;
              System.out.println("Please enter a number between " + min + " and " + max + ".");
            } else {
              System.out.println("Invalid input. Please enter a number.");
              scanner.next(); // clear invalid token
            }
        }
    }

    /**
     * Displays a list of all books in the system with their titles and statuses.
     */
    private static void showBooks() {
        if (bookCount == 0) {
            System.out.println("No books in the system.");
            return;
        }

        System.out.println("-------------------------------------");
        System.out.println("         List of All Books");
        System.out.println("-------------------------------------");
        for (int i = 0; i < bookCount; i++) {
            System.out.println("Book " + (i + 1) + ": " + bookTitles[i] + " [" + bookStatuses[i] + "]");
        }
        System.out.println("-------------------------------------");
    }

    /**
     * Generates and displays a report on the total number of books, available books, and borrowed books.
     */
    private static void generateReport() {
        if (bookCount == 0) {
            System.out.println("No books in the system to generate a report.");
            return;
        }

        int availableCount = 0;
        int borrowedCount = 0;

        for (int i = 0; i < bookCount; i++) {
            if (bookStatuses[i].equals("Available")) {
                availableCount++;
            } else {
                borrowedCount++;
            }
        }

        System.out.println("=====================================");
        System.out.println("           Book Report");
        System.out.println("=====================================");
        System.out.println("Total number of books registered: " + bookCount);
        System.out.println("Total number of available books: " + availableCount);
        System.out.println("Total number of borrowed books: " + borrowedCount);
        System.out.println("-------------------------------------");
    }
}
