package Entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-15T15:59:11")
@StaticMetamodel(Worker.class)
public class Worker_ { 

    public static volatile SingularAttribute<Worker, Integer> id;
    public static volatile SingularAttribute<Worker, Float> salary;
    public static volatile SingularAttribute<Worker, Date> startdate;
    public static volatile SingularAttribute<Worker, String> fio;

}