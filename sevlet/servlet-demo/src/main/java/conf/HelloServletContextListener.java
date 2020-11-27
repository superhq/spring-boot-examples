package conf;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HelloServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("servlet context init");
        ServletContext ctx = sce.getServletContext();
        ctx.setAttribute("java-base/test","this is a test attribute");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servlet context destroy");
    }
}
