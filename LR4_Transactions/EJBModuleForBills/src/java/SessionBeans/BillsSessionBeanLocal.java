
package SessionBeans;

import Entities.Bills;
import java.util.List;
import javax.ejb.Local;


@Local
public interface BillsSessionBeanLocal {
    public void add(Bills bill);
    public void update(Bills bill);
    public List<Bills> getAll();
    public void remove(Bills bill);
    public Bills getBillByID(int id);
    public Bills getBillByFamily(String fio);
}
