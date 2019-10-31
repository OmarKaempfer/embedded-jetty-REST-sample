package es.omarkaempfer;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import webapp.AppResourceConfig;

import javax.servlet.ServletException;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8082);
        server.setHandler(getRESTEasyHandler());
        server.start();
        server.join();
    }

    private static Handler getRESTEasyHandler() {
        ServletContextHandler handler =
                new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

        ServletHolder servlet = handler.addServlet(HttpServletDispatcher.class, "/");

        servlet.setInitParameter("javax.ws.rs.Application",
                AppResourceConfig.class.getCanonicalName());
        return handler;
    }
}
