package com.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Hello", urlPatterns = {"/api/*"})

public class HelloServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String params = req.getParameter("name");
        if (params == null) {
            resp.getWriter().write("Hello world");
        } else {
            resp.getWriter().write("Hello " + params);
        }
        req.getServletContext();

    }
}
