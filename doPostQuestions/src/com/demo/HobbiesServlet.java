package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HobbiesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        // Retrieve multiple selected values
        String[] hobbies = request.getParameterValues("hobby");

        out.println("<html><body>");
        out.println("<h2>Submitted Details</h2>");
        out.println("<p><b>Name:</b> " + name + "</p>");

        out.println("<p><b>Selected Hobbies:</b></p>");

        if (hobbies != null) {
            out.println("<ul>");
            for (String hobby : hobbies) {
                out.println("<li>" + hobby + "</li>");
            }
            out.println("</ul>");
        } else {
            out.println("<p>No hobbies selected.</p>");
        }

        out.println("</body></html>");
    }
}
