
package Controllers;

import Entities.Worker;
import SessionComponents.SessionBeanWorkerLocal;
import WorkWithTransactions.TransactionSessionBeanLocal;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkerServlet extends HttpServlet { 
    @EJB
    SessionBeanWorkerLocal W;
    
    private Worker worker = new Worker();
    
    @EJB
    TransactionSessionBeanLocal T;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Worker> workers = W.getAll();
        request.setAttribute("workers", workers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/showWorkers.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("param");
        RequestDispatcher dispatcher;
        switch (param){
            case ("Update"):
                worker.setFio(request.getParameter("paramfio"));
                worker.setSalary(Float.parseFloat(request.getParameter("paramsalary")));
                W.update(worker);
                dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
                break;
            case ("Create"):
                String fio = request.getParameter("pfio");
                Date startdate = new Date();
                float salary = Float.parseFloat(request.getParameter("psalary"));
                worker = new Worker(fio,salary,startdate);
                T.doubleAdditing(worker);
                dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
                break;
            case ("Delete"):
                int id = Integer.parseInt(request.getParameter("workerid"));
                //W.remove(id);
                T.doubleRemoving(id);
                dispatcher=request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request,response);
            default:
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
