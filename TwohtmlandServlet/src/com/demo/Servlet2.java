package com.demo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Servlet2 extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
//        res.setContentType("text/html");
//        PrintWriter out = res.getWriter();
//        out.println("<h2>Servlet 2 page</h2>");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        HttpSession session = req.getSession(true);
        String user = (String) session.getAttribute("user");

        out.println("<h2>Welcome " + user + "</h2>");

    }
}
