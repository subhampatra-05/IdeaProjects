package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FeedbackServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String comments = request.getParameter("comments");

        out.println("<html><body>");
        out.println("<h2>Thank You for Your Feedback!</h2>");
        out.println("<p><b>Name:</b> " + name + "</p>");
        out.println("<p><b>Comments:</b> " + comments + "</p>");
        out.println("</body></html>");
    }
}