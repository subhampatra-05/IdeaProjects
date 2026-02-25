package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Getservlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("username");   // FIXED
        String email = req.getParameter("email");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<h2>Welcome " + name + "</h2>");
        out.println("<p>Your email: " + email + "</p>");
    }
}