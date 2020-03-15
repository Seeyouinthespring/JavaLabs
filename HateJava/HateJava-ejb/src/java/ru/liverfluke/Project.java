
package ru.liverfluke;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.Stateless;

@Stateless
public class Project implements Serializable {
    private int project_id;
    private String name;
    private Date deadline;
    private boolean execution;
    private float cost;
    private int worker_id;
    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
    
    public Project(){}

    public Project(int project_id, String name, String deadline, boolean execution, float cost, int worker_id){
        this.setProject_id(project_id);
        this.setName(name);
        this.setDeadline(deadline);
        this.setExecution(execution);
        this.setCost(cost);
        this.setWorker_id(worker_id);
    }
    
    public Project(String name, String deadline, boolean execution, float cost, int worker_id){
        this.setName(name);
        this.setDeadline(deadline);
        this.setExecution(execution);
        this.setCost(cost);
        this.setWorker_id(worker_id);
    }
    
    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        try {
            this.deadline = df.parse(deadline);
        } catch (ParseException ex) {
            System.out.println("Произошла ошибка в соответствии типов: ");
            System.out.println(ex.getMessage());
        }
    }

    public boolean isExecution() {
        return execution;
    }

    public void setExecution(boolean execution) {
        this.execution = execution;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
    }
    
    public String getString(){
        String str = "project_id = "+project_id+
                ". name = "+name+
                ". deadline = "+deadline+
                ". execution = "+execution+
                ". cost = "+cost+
                ". worker_id = "+worker_id;
        return str;
    }
}
