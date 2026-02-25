import java.sql.*;
import java.util.Scanner;
public class batch {
    private static final String url = "jdbc:mysql://localhost:3306/forjdbc";
    private static final String username = "root";
    private static final String password = "Subham@0511";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO Learner VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("Enter id: ");
                int id = sc.nextInt();
                System.out.print("Enter name: ");
                String name = sc.next();
                System.out.print("Enter age: ");
                int age = sc.nextInt();
                System.out.print("Enter salary: ");
                double salary = sc.nextDouble();
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setInt(3, age);
                ps.setDouble(4, salary);
                ps.addBatch();
                System.out.print("Do you want to add more? (yes/no): ");
                String choice = sc.next();
                if (choice.equalsIgnoreCase("no")) {
                    break;
                }
            }
            ps.executeBatch();
            System.out.println("Batch executed successfully!");
            ps.close();
            connection.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}