/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.liverfluke.stateful;

import javax.ejb.Local;

/**
 *
 * @author colya
 */
@Local
public interface StatefulSessionBeanInterface {
    public void changeSalary(float plus);
    public float getSalary();
    public String getName();
    public void setName(String name);
}
