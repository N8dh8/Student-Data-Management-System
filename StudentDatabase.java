import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentDatabase {
    private Map<Integer, Student> students;
    private Scanner scanner;

    public StudentDatabase() {
        this.students = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student by Roll No");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    searchStudent();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter Roll No: ");
        int rollNo = scanner.nextInt();
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Grade: ");
        String grade = scanner.next();

        Student student = new Student(name, age, grade);
        students.put(rollNo, student);
        System.out.println("Student added successfully!");
    }

    private void updateStudent() {
        System.out.print("Enter Roll No: ");
        int rollNo = scanner.nextInt();

        if (students.containsKey(rollNo)) {
            System.out.print("Enter Name: ");
            String name = scanner.next();
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            System.out.print("Enter Grade: ");
            String grade = scanner.next();

            Student student = new Student(name, age, grade);
            students.put(rollNo, student);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    private void deleteStudent() {
        System.out.print("Enter Roll No: ");
        int rollNo = scanner.nextInt();

        if (students.containsKey(rollNo)) {
            students.remove(rollNo);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    private void searchStudent() {
        System.out.print("Enter Roll No: ");
        int rollNo = scanner.nextInt();

        if (students.containsKey(rollNo)) {
            Student student = students.get(rollNo);
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Grade: " + student.getGrade());
        } else {
            System.out.println("Student not found!");
        }
    }

    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();
        studentDatabase.run();
    }
}

class Student {
    private String name;
    private int age;
    private String grade;

    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }
}