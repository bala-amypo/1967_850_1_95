package com.example.demo.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleHelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.setContentType("text/plain");
        res.setStatus(200);
        res.getWriter().write("Hello from Simple Servlet");
    }

    public String getServletInfo() {
        return "SimpleHelloServlet";
    }
}
