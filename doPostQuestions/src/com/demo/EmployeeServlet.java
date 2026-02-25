package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String salary = request.getParameter("salary");
        String department = request.getParameter("department");

        out.println("<html><body>");
        out.println("<h2>Employee Details</h2>");

        out.println("<table border='1' cellpadding='5'>");
        out.println("<tr><th>Name</th><th>Salary</th><th>Department</th></tr>");
        out.println("<tr>");
        out.println("<td>" + name + "</td>");
        out.println("<td>" + salary + "</td>");
        out.println("<td>" + department + "</td>");
        out.println("</tr>");
        out.println("</table>");

        out.println("</body></html>");
    }
}