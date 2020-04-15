package SessionBeans;

import Entities.Bills;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;
import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@TransactionAttribute(REQUIRES_NEW)
//@TransactionAttribute(NOT_SUPPORTED)
public class BillsSessionBean implements BillsSessionBeanLocal {

    @PersistenceContext(unitName = "EJBModuleForBillsPU")
    private EntityManager entity_manager; 
    
    @Resource
    private SessionContext ctx;
    
    @Override
    public void add(Bills bill) {
        
        try{
            entity_manager.persist(bill);
            throw new EJBException();
        }catch(Exception e){
            ctx.setRollbackOnly();
            System.out.println("Ошибка при добавлении в таблицу налогов:");
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        }
    }

    @Override
    public void update(Bills bill) {
        entity_manager.merge(bill);
    }

    
    @Override
    public List<Bills> getAll() {
        List<Bills> bills;
        bills = entity_manager.createQuery("SELECT b FROM Bills b").getResultList();
        return bills;
    }
    
    @Override
    public void remove(Bills bill) {
        entity_manager.remove(entity_manager.merge(bill));
        //ctx.setRollbackOnly();
    }

    @Override
    public Bills getBillByID(int id) {
        return entity_manager.find(Bills.class, id);
    }
    
    @Override
    public Bills getBillByFamily(String fio) {
        Bills bill = new Bills();
        Query query = entity_manager.createQuery("SELECT b FROM Bills b WHERE b.fio = :first");
        query.setParameter("first", fio);
        bill = (Bills)query.getSingleResult();
        return bill;
    }
}
