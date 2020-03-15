
package ru.liverfluke;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public final class Worker implements Serializable {
    private int worker_id;
    private String fio;
    private float salary;
    private Date startDate;
    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
    
    public Worker(){}
    
    public Worker(int worker_id, String fio, float salary, String startDate)
    {
        this.setWorker_id(worker_id);
        this.setFio(fio);
        this.setSalary(salary);
        this.setStartDate(startDate);
    }
    
    public Worker(String fio, float salary)
    {
        this.setFio(fio);
        this.setSalary(salary);
    }

    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        try {
            this.startDate = df.parse(startDate);
        } catch (ParseException ex) {
            System.out.println("Произошла ошибка в соответствии типов: ");
            System.out.println(ex.getMessage());
        }
    }
    
    public String getString(){
        String str = "worker_id = "+worker_id+
                ". fio = "+fio+
                ". salary = "+salary+
                ". startDate = "+startDate;
        return str;
    }
}
