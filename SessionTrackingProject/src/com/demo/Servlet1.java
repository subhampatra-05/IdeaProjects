package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet1 extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String firstname = req.getParameter("firstname");
        String lastname  = req.getParameter("lastname");
        String city      = req.getParameter("city");

        res.addCookie(new Cookie("c_firstname", firstname));
        res.addCookie(new Cookie("c_lastname", lastname));
        res.addCookie(new Cookie("c_city", city));

        HttpSession session = req.getSession();
        session.setAttribute("s_firstname", firstname);
        session.setAttribute("s_lastname", lastname);
        session.setAttribute("s_city", city);

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String url = res.encodeURL(req.getContextPath() + "/servlet2");

        out.println("<h2>Servlet1 Page</h2>");

        out.println("<form action='" + url + "' method='post'>");

        out.println("<input type='hidden' name='h_firstname' value='" + firstname + "'>");
        out.println("<input type='hidden' name='h_lastname' value='" + lastname + "'>");
        out.println("<input type='hidden' name='h_city' value='" + city + "'>");

        out.println("<input type='submit' value='Go to Servlet2'>");
        out.println("</form>");
    }
}