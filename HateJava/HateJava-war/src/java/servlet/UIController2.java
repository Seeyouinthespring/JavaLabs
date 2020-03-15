
package servlet;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.liverfluke.FirstIFace;
import ru.liverfluke.Project;


public class UIController2 extends HttpServlet {

    @EJB
    private FirstIFace P;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Project> projects = P.getAll();
        request.setAttribute("projects", projects);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/showProjects.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
