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

        Cookie[] cookies = req.getCookies();
        boolean cookieFound = false;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("cookieUser")) {
                    out.println("<p>Welcome " + c.getValue() + "</p>");
                    out.println("<b>Data via COOKIE</b><br>");
                    cookieFound = true;
                }
            }
        }
        if (!cookieFound) {
            out.println("<b>No Cookie Data</b><br>");
        }

        HttpSession session = req.getSession(false);
        if (session != null) {
            String user = (String) session.getAttribute("sessionUser");
            out.println("<p>Welcome " + user + "</p>");
            out.println("<b>Data via HTTP SESSION</b><br>");

            if (req.isRequestedSessionIdFromURL()) {
                out.println("<b>Session tracked using URL REWRITING</b><br>");
            } else {
                out.println("<b>Session tracked using COOKIE (JSESSIONID)</b><br>");
            }
        } else {
            out.println("<b>No Session Data</b><br>");
        }

        String hiddenUser = req.getParameter("hiddenUser");
        if (hiddenUser != null) {
            out.println("<p>Welcome " + hiddenUser + "</p>");
            out.println("<b>Data via HIDDEN FORM FIELD</b><br>");
        }
    }
}