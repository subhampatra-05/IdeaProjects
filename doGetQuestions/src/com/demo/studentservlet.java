package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class studentservlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("name");   // FIXED
        String rollno = req.getParameter("rollno");
        String course = req.getParameter("course");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<p>Name : " + name + "</p>");
        out.println("<p>Roll Number : " + rollno + "</p>");
        out.println("<p>Course Name : " + course + "</p>");
    }
}