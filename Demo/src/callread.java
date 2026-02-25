import java.sql.*;
public class callread {
    private static final String URL ="jdbc:mysql://localhost:3306/studentmanagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Subham@0511";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String query = "{call getStudentById(?)}";
            CallableStatement cs = connection.prepareCall(query);
            cs.setInt(1, 2);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getInt("age") + " " +
                                rs.getString("grade")
                );
            }
            rs.close();
            cs.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}