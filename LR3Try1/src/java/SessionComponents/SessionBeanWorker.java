package SessionComponents;

import Entities.Worker;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class SessionBeanWorker implements SessionBeanWorkerLocal {
    
    @PersistenceContext(unitName = "LR3Try1PU")
    private EntityManager entity_manager;
    
    @Override
    public void add(Worker worker) {
        entity_manager.persist(worker);
    }

    @Override
    public void update(Worker worker) {
        entity_manager.merge(worker);
    }

    @Override
    public void remove(Worker worker) {
        entity_manager.remove(entity_manager.merge(worker));
    }

    @Override
    public List<Worker> getAll() {
        List<Worker> workers;
        workers = entity_manager.createQuery("SELECT w FROM Worker w").getResultList();
        return workers;
    }

    @Override
    public Worker getWorkerByID(int id) {
        return entity_manager.find(Worker.class, id);
    }
    
}
