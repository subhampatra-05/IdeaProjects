import java.sql.*;
import java.util.Scanner;
public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/studentmanagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Subham@0511";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to Database Successfully!\n");
            while (true) {
                System.out.println("===== STUDENT MANAGEMENT MENU =====");
                System.out.println("1. Add Student");
                System.out.println("2. Show All Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Grade: ");
                        String grade = sc.nextLine();
                        student.addStudent(connection, id, name, age, grade);
                        break;
                    case 2:
                        student.showAllStudents(connection);
                        break;
                    case 3:
                        System.out.print("Enter ID to update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new Name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new Age: ");
                        int newAge = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new Grade: ");
                        String newGrade = sc.nextLine();
                        student.updateStudent(connection, uid, newName, newAge, newGrade);
                        break;
                    case 4:
                        System.out.print("Enter ID to delete: ");
                        int did = sc.nextInt();
                        student.deleteStudent(connection, did);
                        break;
                    case 5:
                        System.out.println("Exiting.");
                        connection.close();
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice! Try again.\n");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
