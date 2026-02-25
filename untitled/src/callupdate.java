import java.sql.*;
public class callupdate {
    private static final String URL ="jdbc:mysql://localhost:3306/studentmanagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Subham@0511";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String query = "{call updateStudent(?, ?)}";
            CallableStatement cs = connection.prepareCall(query);
            cs.setInt(1, 1);
            cs.setString(2, "A+");
            cs.executeUpdate();
            System.out.println("Student updated!");
            cs.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
