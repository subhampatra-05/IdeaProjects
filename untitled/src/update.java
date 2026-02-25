import java.sql.*;
public class update {
    private static final String URL = "jdbc:mysql://localhost:3306/forjdbc";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Subham@0511";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String query ="UPDATE Learner SET salary = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setDouble(1, 65000.0);
            ps.setInt(2, 2);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record updated successfully!");
            } else {
                System.out.println("No record found with given ID.");
            }
            ps.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
