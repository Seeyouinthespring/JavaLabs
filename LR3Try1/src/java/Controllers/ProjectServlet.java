/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Project;
import Entities.Worker;
import SessionComponents.SessionBeanProjectLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author colya
 */
public class ProjectServlet extends HttpServlet {

    @EJB
    SessionBeanProjectLocal P;
    
    //private Project project = new Project();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("param");
        RequestDispatcher dispatcher;
        switch (param){
            case ("All"):
                List<Project> projects = P.getAll();
                request.setAttribute("projects", projects);
                dispatcher = request.getRequestDispatcher("/showProjects.jsp");
                dispatcher.forward(request, response);
                break;
            case ("Exe"):
                List<Project> projects2 = P.getExecuted();
                request.setAttribute("projects", projects2);
                dispatcher = request.getRequestDispatcher("/showExeProjects.jsp");
                dispatcher.forward(request, response);
                break;
            default:
                dispatcher=request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request,response);
        }
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
