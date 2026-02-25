package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SkillsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("username");

        // Retrieve multiple checkbox values
        String[] skills = req.getParameterValues("skill");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<h2>User Details</h2>");
        out.println("<p>Name: " + name + "</p>");

        out.println("<p>Selected Skills:</p>");

        if (skills != null) {
            for (String s : skills) {
                out.println("<li>" + s + "</li>");
            }
        } else {
            out.println("No skills selected.");
        }
    }
}