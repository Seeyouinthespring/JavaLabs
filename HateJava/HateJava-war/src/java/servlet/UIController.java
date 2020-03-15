

package servlet;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.liverfluke.Worker;
import ru.liverfluke.IWorker;


public class UIController extends HttpServlet {
    @EJB
    private IWorker W;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("param");
        RequestDispatcher dispatcher;
         switch (param){
             case ("getallworkers"):
                 List<Worker> workers = W.getAll();
                 request.setAttribute("workers", workers);
                 dispatcher = request.getRequestDispatcher("/showWorkers.jsp");
                 dispatcher.forward(request, response);
                 break;
             case ("getearnings"):
                 int id = Integer.parseInt(request.getParameter("workerid"));
                 int earned = W.countEarnings(id);
                 request.setAttribute("earnings", earned);
                 dispatcher = request.getRequestDispatcher("/earned.jsp");
                 dispatcher.forward(request, response);
         }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
