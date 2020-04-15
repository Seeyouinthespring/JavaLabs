package SessionComponents;

import Entities.Worker;
import java.util.List;
import javax.annotation.Resource;
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
public class SessionBeanWorker implements SessionBeanWorkerLocal {
    
    @PersistenceContext(unitName = "LR3Try1PU")
    private EntityManager entity_manager;
    
    @Resource
    private SessionContext ctx;
    
    @Override
    public void add(Worker worker) {
        entity_manager.persist(worker);
        ctx.setRollbackOnly();
    }

    @Override
    public void update(Worker worker) {
        entity_manager.merge(worker);
    }

    @Override
    //@TransactionAttribute(NOT_SUPPORTED)
    public void remove(int id) {
        Worker worker = getWorkerByID(id);
        entity_manager.remove(entity_manager.merge(worker));
        //Query query;
        //query = entity_manager.createQuery("DELETE FROM Worker w WHERE w.id = :first");
        //query.setParameter("first", id);
        //int rowCount = query.executeUpdate();
        //ctx.setRollbackOnly();
    }

    @Override
    public List<Worker> getAll() {
        List<Worker> workers;
        workers = entity_manager.createQuery("SELECT w FROM Worker w").getResultList();
        return workers;
    }

    @Override
    @TransactionAttribute(NOT_SUPPORTED)
    public Worker getWorkerByID(int id) {
        return entity_manager.find(Worker.class, id);
    }

    @Override
    public void closeEntityManager() {
        this.entity_manager.close();
    } 
}
