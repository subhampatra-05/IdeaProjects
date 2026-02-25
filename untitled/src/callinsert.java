import java.sql.*;
public class callinsert {
    private static final String URL ="jdbc:mysql://localhost:3306/studentmanagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Subham@0511";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String query = "{call addStudent(?, ?, ?, ?)}";
            CallableStatement cs = connection.prepareCall(query);
            cs.setInt(1, 2);
            cs.setString(2, "Subham");
            cs.setInt(3, 21);
            cs.setString(4, "A");
            cs.executeUpdate();
            System.out.println("Student inserted!");
            cs.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
