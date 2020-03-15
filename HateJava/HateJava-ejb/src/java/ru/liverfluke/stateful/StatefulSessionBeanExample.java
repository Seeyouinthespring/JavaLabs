/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.liverfluke.stateful;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import singleton.Interceptor;
import singleton.SingletonSessionBean;

/**
 *
 * @author colya
 */
@Stateful(name="Salary")
@Named
@SessionScoped
public class StatefulSessionBeanExample implements Serializable,StatefulSessionBeanInterface {
    @EJB
    private SingletonSessionBean singleton;
    
    private String name;
    private float salary;
    
    @PostConstruct
    private void init(){
        this.name = "Tom";
        this.salary = 123;
    }
    
    @Override
    //@Interceptors(Interceptor.class)
    public void changeSalary(float plus){
        if (plus<-this.salary)this.salary=0;
                else this.salary+=plus;
        singleton.newVisit();
    }
    
    @Override
    public float getSalary(){
        return this.salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
