package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // Retrieve form data
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String course = req.getParameter("course");
        String gender = req.getParameter("gender");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // Formatted Output
        out.println("<html>");
        out.println("<head><title>Registration Details</title></head>");
        out.println("<body>");

        out.println("<h2>Student Registration Successful</h2>");
        out.println("<hr>");

        out.println("<h3>Student Details</h3>");
        out.println("<p><b>Name:</b> " + name + "</p>");
        out.println("<p><b>Age:</b> " + age + "</p>");
        out.println("<p><b>Course:</b> " + course + "</p>");
        out.println("<p><b>Gender:</b> " + gender + "</p>");

        out.println("<hr>");
        out.println("<p>Thank you for registering!</p>");

        out.println("</body>");
        out.println("</html>");
    }
}