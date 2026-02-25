package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RectangleServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int length = Integer.parseInt(request.getParameter("length"));
        int breadth = Integer.parseInt(request.getParameter("breadth"));

        int area = length * breadth;

        out.println("<html><body>");
        out.println("<h2>Area of Rectangle: " + area + "</h2>");
        out.println("</body></html>");
    }
}