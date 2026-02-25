package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MethodServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("username");

        // Get HTTP method used
        String method = req.getMethod();

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<h2>Form Submitted Successfully</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>HTTP Method Used: <b>" + method + "</b></p>");
    }
}