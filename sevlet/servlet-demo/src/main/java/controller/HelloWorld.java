package controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        session.invalidate();
        //session.invalidate();
        writer.println("Servlet HelloWorld");
        System.out.println("servlet doGet");
        ServletContext ctx = req.getServletContext();
        System.out.println("servlet:" + ctx.getAttribute("java-base/test"));
    }

    @Override
    public void destroy() {
        System.out.println("servlet destroy");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("servlet init");
    }
}
