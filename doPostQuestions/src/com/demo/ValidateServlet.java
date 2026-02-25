package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ValidateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        out.println("<html><body>");

        if (name.isEmpty() || email.isEmpty()) {
            out.println("<h3 style='color:red;'>Error: All fields are required!</h3>");
        } else {
            response.sendRedirect("success.html");
            out.println("Name: " + name + "<br>");
            out.println("Email: " + email);
        }

        out.println("</body></html>");
    }
}
