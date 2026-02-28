package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<h2>Servlet2 Page</h2>");

        out.println("<h3>Using Cookies</h3>");
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().startsWith("c_")) {
                    out.println(c.getName() + " : " + c.getValue() + "<br>");
                }
            }
        } else {
            out.println("No cookies found<br>");
        }

        /* ========= HTTP SESSION ========= */
        out.println("<h3>Using HttpSession</h3>");
        HttpSession session = req.getSession(false);
        if (session != null) {
            out.println("First Name: " + session.getAttribute("s_firstname") + "<br>");
            out.println("Last Name: " + session.getAttribute("s_lastname") + "<br>");
            out.println("City: " + session.getAttribute("s_city") + "<br>");

            if (req.isRequestedSessionIdFromURL()) {
                out.println("<b>Session tracked using URL Rewriting</b><br>");
            } else {
                out.println("<b>Session tracked using COOKIE (JSESSIONID)</b><br>");
            }
        }

        out.println("<h3>Using Hidden Form Fields</h3>");
        out.println("First Name: " + req.getParameter("h_firstname") + "<br>");
        out.println("Last Name: " + req.getParameter("h_lastname") + "<br>");
        out.println("City: " + req.getParameter("h_city") + "<br>");
    }
}