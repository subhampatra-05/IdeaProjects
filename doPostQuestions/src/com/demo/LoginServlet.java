package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // Simple validation (Hardcoded)
        if ("admin".equals(username) && "1234".equals(password)) {
            out.println("<h2>Login Successful!</h2>");
            out.println("<p>Welcome, " + username + "</p>");
        } else {
            out.println("<h2>Login Failed!</h2>");
            out.println("<p>Invalid Username or Password</p>");
        }
    }
}