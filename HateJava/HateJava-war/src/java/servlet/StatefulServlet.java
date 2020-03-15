/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.liverfluke.stateful.StatefulSessionBeanInterface;
import singleton.SingletonSessionBean;

/**
 *
 * @author colya
 */
public class StatefulServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StatefulServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StatefulServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @EJB(mappedName="Salary")
    private StatefulSessionBeanInterface sb;
    
    @EJB
    private SingletonSessionBean sing;
    
    RequestDispatcher dispatcher;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String name = sb.getName();
        float salary = sb.getSalary();
        int visits_number = sing.getVistNum();
        request.setAttribute("nm",name);
        request.setAttribute("slr",salary);
        request.setAttribute("num",visits_number);
        dispatcher = request.getRequestDispatcher("/name_salary.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        float difference = Float.parseFloat(request.getParameter("diff"));
        sb.changeSalary(difference);
        dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
