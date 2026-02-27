package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet1 extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String user = req.getParameter("username");

        // COOKIE
        Cookie c = new Cookie("user", user);
        c.setMaxAge(3600);
        res.addCookie(c);

        // HTTP SESSION
        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // CONTEXT PATH
        String contextPath = req.getContextPath();

        // URL + URL REWRITING
        String servlet2URL = res.encodeURL(contextPath + "/servlet2");

        out.println("<h2>Servlet 1 page</h2>");
        out.println("<form action='" + servlet2URL + "' method='post'>");
        out.println("<input type='submit' value='Go to Servlet2'>");
        out.println("</form>");
    }
}