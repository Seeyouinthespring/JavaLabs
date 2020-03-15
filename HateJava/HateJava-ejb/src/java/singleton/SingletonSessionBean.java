/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;

/**
 *
 * @author colya
 */
@Singleton
@Startup
public class SingletonSessionBean {

    private int visitNum;
        
    @PostConstruct
    private void init(){
        this.visitNum = 0;
    }
    
  // @Override
    public void newVisit(){
        this.visitNum++;
    }
    
    //@Override
    public int getVistNum() {
        return visitNum;
    }
}
