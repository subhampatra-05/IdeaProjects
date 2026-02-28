package com.demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Servlet1 extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String user = req.getParameter("username");

        Cookie c = new Cookie("cookieUser", user);
        c.setMaxAge(3600);
        res.addCookie(c);

        HttpSession session = req.getSession();
        session.setAttribute("sessionUser", user);

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String url = res.encodeURL(req.getContextPath() + "/servlet2");

        out.println("<h2>Servlet1 Page</h2>");

        out.println("<form action='" + url + "' method='post'>");
        out.println("<input type='hidden' name='hiddenUser' value='" + user + "'>");
        out.println("<input type='submit' value='Go to Servlet2'>");
        out.println("</form>");
    }
}