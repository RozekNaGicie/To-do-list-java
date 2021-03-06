package com.app;

import com.sun.net.httpserver.HttpServer;
import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.webapp.*;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        var webapp = new WebAppContext();
        var server = new Server(8080);
        /**
         * it's should fixed problem with saving html file
         */
        webapp.setInitParameter("org.eclipse.jetty.servlet.Default.maxCachedFiles", "0");
        webapp.setResourceBase("/src/main/webapp");
        webapp.setContextPath("/");
        webapp.setConfigurations(new Configuration[]{
                new AnnotationConfiguration(),
                new WebInfConfiguration(),
                new WebXmlConfiguration(),
                new MetaInfConfiguration(),
                new FragmentConfiguration(),
                new EnvConfiguration(),
                new PlusConfiguration(),
                new JettyWebXmlConfiguration()
        });
        webapp.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/classes/.*");
//        webapp.addServlet(HelloServlet.class, "/api/*");
        server.setHandler(webapp);
        server.addLifeCycleListener(new AbstractLifeCycle.AbstractLifeCycleListener() {
            @Override
            public void lifeCycleStopped(LifeCycle event) {
                HibernateUtil.close();
            }
        });
        server.start();
        server.join();
    }
}
