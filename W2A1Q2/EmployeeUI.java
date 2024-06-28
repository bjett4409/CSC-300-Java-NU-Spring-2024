package W2A1Q2;

class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Name: " + name);
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }
}

class Employee extends Person {
    private int id;

    public Employee(String name, int id) {
        super(name);
        this.id = id;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("ID: " + id);
    }

    @Override
    public String toString() {
        return super.toString() + ", ID: " + id;
    }
}

class Project {
    private char code;
    private Employee employee;

    public Project(char code, Employee employee) {
        this.code = code;
        this.employee = employee;
    }

    public void display() {
        System.out.println("Project Code: " + code);
        employee.display();
    }

    @Override
    public String toString() {
        return "Project Code: " + code + ", Employee: [" + employee + "]";
    }
}

public class EmployeeUI {
    public static void main(String[] args) {
        Person person = new Person("Malcolm X");
        Employee employee = new Employee("Brenda Thompson", 395);
        Project project = new Project('A', employee);

        person.display();
        System.out.println(person);

        employee.display();
        System.out.println(employee);

        project.display();
        System.out.println(project);
    }
}
