
package singleton;

import java.io.Serializable;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;


public class Interceptor implements Serializable{
    
    SingletonSessionBean sing;
    
    @AroundInvoke 
    public Object addInter(InvocationContext context) throws Exception{
        sing.newVisit();
        return context.proceed();
    }  
}
