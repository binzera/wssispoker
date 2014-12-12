package br.gms.wssispoker.rest;

import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/welcome-servlet")
public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = 4312217269766216580L;
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.append("Essa é a minha primeira app no openshift!");
        writer.close();
    }
}
