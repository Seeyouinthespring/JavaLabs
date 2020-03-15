
package ru.liverfluke;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface FirstIFace {
    public abstract List<Project> getAll();
}
