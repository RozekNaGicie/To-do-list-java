package com.app;

import com.sun.net.httpserver.HttpServer;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("It's logger test");
        logger.info("It logger test2");

    }
}
