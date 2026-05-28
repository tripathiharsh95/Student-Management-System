import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank you for using Student Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);
    }

    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        Student student = new Student(id, name, age, course);
        students.add(student);

        System.out.println("Student added successfully!");
    }

    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("\n===== Student List =====");
            for (Student student : students) {
                student.displayStudent();
            }
        }
    }

    public static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Student found:");
                student.displayStudent();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();

        for (Student student : students) {
            if (student.getId() == id) {

                sc.nextLine();

                System.out.print("Enter new name: ");
                String name = sc.nextLine();

                System.out.print("Enter new age: ");
                int age = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter new course: ");
                String course = sc.nextLine();

                student.updateStudent(name, age, course);

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }
}