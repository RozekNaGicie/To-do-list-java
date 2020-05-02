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
import java.util.Optional;

@WebServlet(name = "Hello", urlPatterns = {"/api/*"})

public class HelloServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);
    private HelloService service;
    private final String name = "name";

    /**
     * Servlet needs it
     */
    @SuppressWarnings("unused")
    public HelloServlet() {
        this(new HelloService());
}

    HelloServlet(HelloService service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Got request from " + req.getRequestURI());
        resp.getWriter().write(service.prepareGreetings(req.getParameter(name)));
    }
}
