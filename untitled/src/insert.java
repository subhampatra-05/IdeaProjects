import java.sql.*;
public class insert {
    private static final String URL = "jdbc:mysql://localhost:3306/forjdbc";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Subham@0511";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String query ="INSERT INTO Learner (id, name, age, salary) VALUES (?,?, ?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, 2);
            ps.setString(2, "patra");
            ps.setInt(3, 21);
            ps.setDouble(4, 45000.50);
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Record inserted successfully!");
            }
            ps.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
