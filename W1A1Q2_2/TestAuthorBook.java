package W1A1Q2_2;

import java.util.Scanner;

class Author {
    private String name;
    private String email;
    private char gender;

    // Constructor
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for gender
    public char getGender() {
        return gender;
    }

    // Print function
    public String print() {
        return name + " (" + gender + ") at " + email;
    }
}

class Book {
    private String name;
    private Author author;
    private double price;

    // Constructor
    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for author
    public Author getAuthor() {
        return author;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }

    // Print function
    public String print() {
        return name + " by " + author.print();
    }
}

public class TestAuthorBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting user input for Author details
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();
        
        System.out.print("Enter author email: ");
        String authorEmail = scanner.nextLine();
        
        System.out.print("Enter author gender (M/F): ");
        char authorGender = scanner.next().charAt(0);
        scanner.nextLine();  // consume the remaining newline

        Author author = new Author(authorName, authorEmail, authorGender);

        // Getting user input for Book details
        System.out.print("Enter book name: ");
        String bookName = scanner.nextLine();
        
        System.out.print("Enter book price: ");
        double bookPrice = scanner.nextDouble();

        Book book = new Book(bookName, author, bookPrice);

        System.out.println(book.print());

        scanner.close();
    }
}