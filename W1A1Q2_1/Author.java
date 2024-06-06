import java.util.Scanner;

public class Author { // Establishing the class for Author name, email, and gender type
    private String name;
    private String email;
    private char gender;

    // This is the start of the constructor for this program
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() { // Author Name
        return name;
    }

    public String getEmail() { // Author Email
        return email;
    }

    public void setEmail(String email) { // Setting Email string
        this.email = email;
    }

    public char getGender() { // Getting the gender type, male or female
        return gender;
    }

    public String print() {
        return "Author's Name = " + name + ", E-mail = " + email + ", Gender = " + gender + "]";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: "); // User input Author's name
        String name = scanner.nextLine();

        System.out.print("Enter email: "); // User input Author's email
        String email = scanner.nextLine();

        System.out.print("Enter gender (M/F): "); // User input Author's gender
        char gender = scanner.next().charAt(0);

        Author author = new Author(name, email, gender);
        System.out.println(author.print());

        scanner.close();
    }
}