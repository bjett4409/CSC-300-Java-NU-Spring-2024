package W1A1Q2_2;

import java.util.Scanner;

// Setting up the class for the Author information to include:
// their name, their email address, and their gender type

class Author {
    private String name;
    private String email;
    private char gender;

    // Start of Constructor from name, email, gender
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() { // Get the Author's Name
        return name;
    }

    public String getEmail() { // Get the Author's email
        return email;
    }

    public void setEmail(String email) { // The Author's email is set
        this.email = email;
    }

    public char getGender() { // Get the Author's gender
        return gender;
    }

    public String print() { // Printing the Author's name, gender, and email
        return name + " (" + gender + ") at " + email;
    }
}

// Setting up a class for the book information to include:
// the book name and the book price

class Book {
    private String name;
    private Author author;
    private double price;

    // Start of Constructor for name of the book, the Author's name, and price of book
    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() { // Get the Name of the Book
        return name;
    }

    public Author getAuthor() { // Get the Author's name
        return author;
    }

    public double getPrice() { // Get the price of the book
        return price;
    }

    public void setPrice(double price) { // Setting the price for the book
        this.price = price;
    }

    public String print() { // Printing the name of the book and the Author's name
        return name + " by " + author.print();
    }
}

// We will combine the user input to display both the Author information
// Then display the book name and the book price

public class TestAuthorBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter author name: "); // Author's name
        String authorName = scanner.nextLine();
        
        System.out.print("Enter author email: "); // Author's email
        String authorEmail = scanner.nextLine();
        
        System.out.print("Enter author gender (M/F): "); // Author's gender (male or female)
        char authorGender = scanner.next().charAt(0);
        scanner.nextLine();  // receiving the user input and moving to new line

        Author author = new Author(authorName, authorEmail, authorGender);

        System.out.print("Enter book name: "); // Book name
        String bookName = scanner.nextLine();
        
        System.out.print("Enter book price: "); // Book Price
        double bookPrice = scanner.nextDouble();

        Book book = new Book(bookName, author, bookPrice);

        System.out.println(book.print());

        scanner.close();
    }
}