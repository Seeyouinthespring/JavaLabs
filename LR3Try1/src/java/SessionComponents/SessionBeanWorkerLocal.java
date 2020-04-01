package SessionComponents;

import Entities.Worker;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SessionBeanWorkerLocal {
    public void add(Worker worker);
    public void update(Worker worker);
    public void remove(Worker worker);
    public List<Worker> getAll();
    public Worker getWorkerByID(int id);
}
