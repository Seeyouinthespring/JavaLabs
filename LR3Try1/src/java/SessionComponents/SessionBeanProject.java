
package SessionComponents;

import Entities.Project;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SessionBeanProject implements SessionBeanProjectLocal {
    @PersistenceContext(unitName = "LR3Try1PU")
    private EntityManager entity_manager;

    @Override
    public List<Project> getAll(){
        List<Project> projects;
        projects = entity_manager.createQuery("SELECT p FROM Project p").getResultList();
        return projects;
    }

    @Override
    public List<Project> getExecuted() {
        List<Project> projects;
        projects = entity_manager.createQuery("SELECT p FROM Project p where p.execution=true").getResultList();
        return projects;
    }
}
