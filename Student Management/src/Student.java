import java.sql.*;
public class Student {
    public void addStudent(Connection connection, int id, String name, int age, String grade) {
        try {
            String query = "INSERT INTO student (id, name, age, grade) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, grade);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student added successfully!\n");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void showAllStudents(Connection connection) {
        try {
            String query = "SELECT * FROM student";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("\nID | NAME | AGE | GRADE");
            System.out.println("----------------------------");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("grade")
                );
            }
            System.out.println();
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateStudent(Connection connection, int id, String newName, int newAge, String newGrade) {
        try {
            String query = "UPDATE student SET name = ?, age = ?, grade = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newName);
            ps.setInt(2, newAge);
            ps.setString(3, newGrade);
            ps.setInt(4, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student updated successfully!\n");
            } else {
                System.out.println("No student found with ID " + id + "\n");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteStudent(Connection connection, int id) {
        try {
            String query = "DELETE FROM student WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted successfully!\n");
            } else {
                System.out.println("No student found with ID " + id + "\n");
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
