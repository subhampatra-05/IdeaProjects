package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class MultiplyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException{
        String n1 = req.getParameter("num1");
        String n2 = req.getParameter("num2");

        // Convert to integers
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        int m=num1*num2;

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<h2>Result</h2>");
        out.println("<p>First Number: " + num1 + "</p>");
        out.println("<p>Second Number: " + num2 + "</p>");
        out.println("<h3>Product is: " + m + "</h3>");


    }
}
