package com.example.demo.servlet;

import jakarta.servlet.http.*;
import java.io.IOException;

public class SimpleHelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.setContentType("text/plain");
        res.getWriter().write("Hello from Simple Servlet");
    }

    public String getServletInfo() {
        return "SimpleHelloServlet v1";
    }
}
