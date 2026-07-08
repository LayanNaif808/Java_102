import java.util.Scanner;

public class StudentManagementSystem {

    // Global arrays to store student names and grades (Max 50 students)
    static String[] studentNames = new String[50];
    static double[] studentGrades = new double[50];
    static int studentCount = 0; // Keeps track of how many students are added

    // Method to add a new student and their grade
    public static void addStudent(String name, double grade) {
        if (studentCount < studentNames.length) {
            studentNames[studentCount] = name;
            studentGrades[studentCount] = grade;
            studentCount++;
            System.out.println("Student added successfully!");
        } else {
            System.out.println("System is full! Cannot add more students.");
        }
    }

    // Method to display all added students
    public static void displayStudents() {
        if (studentCount == 0) {
            System.out.println("No students found in the system.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Name: " + studentNames[i] + " | Grade: " + studentGrades[i]);
        }
    }

    // Method to calculate the average grade with Exception Handling
    public static void calculateAverage() {
        try {
            // Try-catch block to handle division by zero if no students are added
            if (studentCount == 0) {
                throw new ArithmeticException("Division by zero error: No students to calculate average.");
            }

            double sum = 0;
            for (int i = 0; i < studentCount; i++) {
                sum += studentGrades[i];
            }
            double average = sum / studentCount;
            System.out.printf("The average grade of students is: %.2f\n", average);

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to Student Management System");

        // Loop to keep the system running until the user decides to exit
        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Calculate Average Grade");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); // Clear scanner buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = input.nextLine();
                    System.out.print("Enter Student Grade: ");
                    double grade = input.nextDouble();
                    addStudent(name, grade);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    calculateAverage();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        input.close();
    }
}

