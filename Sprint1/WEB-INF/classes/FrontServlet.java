package etu1845.framework.servlet;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class FrontServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        try {
            String cs = processRequest(res, req);
            out.println(cs);
        } catch (Exception e) {
            out.println("Exception: " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        try {
            String cs = processRequest(res, req);
            out.println(cs);
        } catch (Exception e) {
            out.println("Exception: " + e.getMessage());
        }
    }

    public String processRequest(HttpServletResponse res, HttpServletRequest req) throws Exception {
        StringBuffer url = req.getRequestURL();
        String context = req.getContextPath(); 
        int index = url.indexOf(req.getContextPath());
        String otherArgs = "";
        for (int i = index + (context.length()) + 1; i < url.length(); i++) {
            otherArgs += url.toString().charAt(i);
        }
        return otherArgs;
    }

}
