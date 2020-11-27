package conf;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class HelloServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request destroy");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request init");
        ServletContext ctx = sre.getServletContext();
        System.out.println("request listener:" + ctx.getAttribute("java-base/test"));
    }
}
