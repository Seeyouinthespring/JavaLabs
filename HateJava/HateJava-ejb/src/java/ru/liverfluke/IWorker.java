
package ru.liverfluke;

import java.util.List;
import javax.ejb.Local;

@Local
public interface IWorker {
    public abstract int countEarnings(int id);
    public abstract List<Worker> getAll();
}
