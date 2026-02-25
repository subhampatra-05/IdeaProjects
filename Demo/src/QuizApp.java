import java.sql.*;
import java.util.Scanner;

public class QuizApp {

    static final String URL = "jdbc:mysql://localhost:3306/quiztime";
    static final String USER = "root";      // change if needed
    static final String PASS = "Subham@0511";  // change if needed

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Enter Password: ");
        String password = sc.next();

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            // 🔐 LOGIN
            PreparedStatement psLogin =
                    con.prepareStatement("SELECT * FROM student WHERE rollnumber=? AND password=?");
            psLogin.setInt(1, roll);
            psLogin.setString(2, password);

            ResultSet rsLogin = psLogin.executeQuery();

            if (!rsLogin.next()) {
                System.out.println("❌ Invalid Roll Number or Password");
                return;
            }

            System.out.println("\n✅ Login Successful");
            System.out.println("------ Quiz Started ------\n");

            // 📘 FETCH QUESTIONS
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM questions");

            int marks = 0;

            while (rs.next()) {
                System.out.println(rs.getInt("slno") + ". " + rs.getString("question"));
                System.out.println("1. " + rs.getString("opt1"));
                System.out.println("2. " + rs.getString("opt2"));
                System.out.println("3. " + rs.getString("opt3"));
                System.out.println("4. " + rs.getString("opt4"));

                System.out.print("Enter your choice (1-4): ");
                int answer = sc.nextInt();

                if (answer == rs.getInt("correct_opt")) {
                    marks++;
                }
                System.out.println();
            }

            // 📝 STORE RESULT
            PreparedStatement psResult =
                    con.prepareStatement("UPDATE result SET marks=? WHERE rollnumber=?");
            psResult.setInt(1, marks);
            psResult.setInt(2, roll);
            psResult.executeUpdate();

            // 🎯 DISPLAY RESULT
            System.out.println("------ Quiz Finished ------");
            System.out.println("Your Score: " + marks);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}