package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SIservlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // Get parameters
        String n1 = req.getParameter("num1");
        String n2 = req.getParameter("num2");
        String n3 = req.getParameter("num3");

        // Convert to integers
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        int num3 = Integer.parseInt(n3);

        int si=(num1*num2*num3)/100;

        // Send response
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<h2>Result</h2>");
        out.println("<p>Principle amount : " + num1 + "</p>");
        out.println("<p>Rate of Interest : " + num2 + "</p>");
        out.println("<p>Time : " + num3 + "</p>");
        out.println("<h3>Simple Interest : " + si + "</h3>");
    }
}
