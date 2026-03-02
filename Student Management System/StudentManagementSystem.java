import java.util.*;

public class StudentManagementSystem {
    private Map<Integer, Student> students = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int roll = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        students.put(roll, new Student(name, roll, grade));
        System.out.println("Student added successfully!");
    }

    public void removeStudent() {
        System.out.print("Enter roll number to remove: ");
        int roll = scanner.nextInt();
        scanner.nextLine();
        if (students.remove(roll) != null) {
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void searchStudent() {
        System.out.print("Enter roll number to search: ");
        int roll = scanner.nextInt();
        scanner.nextLine();
        Student student = students.get(roll);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student s : students.values()) {
                System.out.println(s);
            }
        }
    }

    public void start() {
        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: addStudent(); break;
                case 2: removeStudent(); break;
                case 3: searchStudent(); break;
                case 4: displayAllStudents(); break;
                case 5: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}
