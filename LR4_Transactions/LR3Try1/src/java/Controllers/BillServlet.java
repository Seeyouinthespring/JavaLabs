package Controllers;

import Entities.Bills;
import SessionBeans.BillsSessionBeanLocal;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BillServlet extends HttpServlet {
    @EJB
    BillsSessionBeanLocal B;
    
    private Bills bill = new Bills();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Bills> bills = B.getAll();
        request.setAttribute("bills", bills);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/showBills.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String param = request.getParameter("param");
        RequestDispatcher dispatcher;
        switch (param){
            case ("Update"):
                bill.setFio(request.getParameter("paramfio"));
                bill.setBillsum(Float.parseFloat(request.getParameter("parambillsum")));
                bill.setOverall(Float.parseFloat(request.getParameter("paramoverall")));
                B.update(bill);
                dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
                break;
            case ("Create"):
                String fio = request.getParameter("pfio");
                float billsum = Float.parseFloat(request.getParameter("pbillsum"));
                float overall = Float.parseFloat(request.getParameter("poverall"));
                bill = new Bills(fio,billsum,overall);
                B.add(bill);
                dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
                break;
            case ("Delete"):
                int id = Integer.parseInt(request.getParameter("billid"));
                bill = B.getBillByID(id);
                B.remove(bill);
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