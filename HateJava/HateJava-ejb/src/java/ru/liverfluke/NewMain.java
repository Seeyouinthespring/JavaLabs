/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.liverfluke;

import java.util.List;

/**
 *
 * @author colya
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionBeanProjects P = new SessionBeanProjects();
        List<Project> projects = P.getAll();
        
        projects.forEach((i) -> {
            System.out.println(i.getString());
        });
    }
    
}
