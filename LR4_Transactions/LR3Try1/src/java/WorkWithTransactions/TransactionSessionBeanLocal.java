
package WorkWithTransactions;

import Entities.Worker;
import javax.ejb.Local;

@Local
public interface TransactionSessionBeanLocal {
    public void doubleAdditing(Worker worker);
    public void doubleRemoving(int id);
}
