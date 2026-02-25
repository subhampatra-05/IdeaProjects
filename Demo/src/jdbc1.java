import java.sql.*;

public class jdbc1 {
    private static final String url="jdbc:mysql://localhost:3306/forjdbc";
    private static final String username="root";
    private static final String password="Subham@0511";
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection= DriverManager.getConnection(url,username,password);
            Statement st = connection.createStatement();
            String query = "select * from Learner";
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double salary = resultSet.getDouble("salary");

                System.out.println(
                        "ID: " + id +
                                ", Name: " + name +
                                ", Age: " + age +
                                ", Salary: " + salary
                );
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}