package assn02;
import java.util.Scanner;

class AllBooks {

    // Create a new scanner object to get user input
    static Scanner scanner = new Scanner(System.in);

    // Create an array to store the books with size 5 and an index to keep track
    static int number_of_books = 5;
    static Book[] books = new Book[number_of_books];
    static int index_of_books = 0;

    int menu() {

        // Print out the library menu with specific formatting with triple quotes to allow for spacing instead of \n
        System.out.println("Library Menu:\n0. Exit\n1. Add a Book\n2. Display All Books\n3. Check Out a Book\n4. Return a Book\nEnter your choice:");

        // Get user input for choice in menu
        int choice = scanner.nextInt();
        scanner.nextLine(); //throw away the \n not consumed by nextInt()

        // Evaluate whether index choice is equal to a menu button, then evaluate button
        switch (choice) {
            case (0):
                System.out.println("Goodbye!");
                break;
            case (1):
                store_book();
                break;
            case (2):
                print_all_books();
                break;
            case (3):
                check_out_book();
                break;
            case (4):
                return_book();
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                break;
        }
        return choice;
    }

    void store_book() {

        // Return if the library is full
        if (index_of_books >= number_of_books) {
            System.out.println("Library is full!");
            return;
        }

        // Create a new book with title and author
        Book bk = new Book();
        System.out.println("Enter book title:");
        bk.title = scanner.nextLine();
        System.out.println("Enter book author:");
        bk.author = scanner.nextLine();
        books[index_of_books] = bk;
        System.out.println("Book added!");

        // Increase the tracker for next free book spot
        index_of_books++;
    }

    void print_all_books() {
        System.out.println("Books in Library:");

        // Loop through each Book in books
        for (int i = 0; i < index_of_books; i++) {
            System.out.println(i + 1 + ". Title: " + books[i].title + ", Author: " + books[i].author + ", Checked Out: " + books[i].checked_out);
        }
    }

    void check_out_book() {
        System.out.println("Enter book number to check out:");

        // Shift by 1 because of indexing of arrays
        int book_check = scanner.nextInt() - 1;

        // Ensure the book they are trying to check out is within range
        if (book_check >= index_of_books) {
            System.out.println("Invalid book number!");

            // Book is checked out
        } else if (books[book_check].checked_out.equals("Yes")) {
            System.out.println("Book is checked out already.");

            // Book is not checked out
        } else {
            books[book_check].checked_out = "Yes";
            System.out.println("Book checked out!");
        }
    }

    void return_book() {
        System.out.println("Enter book number to return:");

        // Shift by 1 because of indexing of arrays
        int book_return = scanner.nextInt() - 1;

        // Ensure the book they are trying to check out is within range
        if (book_return >= index_of_books) {
            System.out.println("Invalid book number!");

            // Book is returned
        } else {
            books[book_return].checked_out = "No";
            System.out.println("Book returned!");
        }
    }
}
