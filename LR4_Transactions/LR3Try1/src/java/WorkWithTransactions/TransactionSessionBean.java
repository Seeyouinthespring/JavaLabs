
package WorkWithTransactions;

import Entities.Bills;
import Entities.Worker;
import SessionBeans.BillsSessionBeanLocal;
import SessionComponents.SessionBeanWorkerLocal;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;


@Stateful
@TransactionManagement(TransactionManagementType.BEAN)
public class TransactionSessionBean implements TransactionSessionBeanLocal {

    @EJB
    SessionBeanWorkerLocal W;
    
    @EJB
    BillsSessionBeanLocal B;
    
    Bills bill = new Bills();
    Worker worker = new Worker();
    
    @Resource 
    javax.transaction.UserTransaction transaction;
    
    @Resource
    private SessionContext ctx;
    
    @Override
    public void doubleAdditing(Worker worker) {
        try{
            transaction.begin();
            W.add(worker);
            bill.setFio(worker.getFio());
            bill.setBillsum((float) (worker.getSalary()*0.13));
            bill.setOverall((float) (worker.getSalary()-worker.getSalary()*0.13));
            B.add(bill);
            transaction.commit();
        }catch(IllegalStateException | SecurityException | EJBException | NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException e){
            System.out.println("Произошла ошибка в транзакции добавления: ");
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        } 
    }

    @Override
    public void doubleRemoving(int id) {
        try{
            transaction.begin();
            Worker workerToDelete = W.getWorkerByID(id);
            W.remove(id);
            bill = B.getBillByFamily(workerToDelete.getFio());
            B.remove(bill);
            transaction.commit();
        }
        catch(Exception e){
            System.out.println("Произошла ошибка в транзакции удаления: ");
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        }
    }
}
