package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<h2>Servlet 2 page</h2>");

        /* ================= COOKIE ================= */
        Cookie[] cookies = req.getCookies();
        boolean cookieFound = false;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    out.println("<p>Welcome " + c.getValue() + "</p>");
                    out.println("<p><b>Data saved using COOKIE</b></p>");
                    cookieFound = true;
                }
            }
        }

        if (!cookieFound) {
            out.println("<p><b>No user cookie received</b></p>");
        }

        /* ================= HTTP SESSION ================= */
        HttpSession session = req.getSession(false);

        if (session != null) {
            String user = (String) session.getAttribute("user");
            out.println("<p>Welcome " + user + "</p>");
            out.println("<p><b>Data saved using HTTP SESSION</b></p>");

            /* ================= URL REWRITING CHECK ================= */
            if (req.isRequestedSessionIdFromURL()) {
                out.println("<p><b>Session tracked using URL REWRITING</b></p>");
            } else {
                out.println("<p><b>Session tracked using COOKIE (JSESSIONID)</b></p>");
            }
        } else {
            out.println("<p><b>No active session found</b></p>");
        }
    }
}