package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Servlet1 extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String user = req.getParameter("username");

        // Create session
        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h2>Servlet 1 page</h2>");
        out.println("<form action='servlet2' method='post'>");
        out.println("<input type='submit' value='Go to Servlet2'>");
        out.println("</form>");

    }
}
