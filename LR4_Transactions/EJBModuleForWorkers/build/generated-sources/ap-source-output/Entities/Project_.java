package Entities;

import Entities.Worker;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-11T03:09:35")
@StaticMetamodel(Project.class)
public class Project_ { 

    public static volatile SingularAttribute<Project, Boolean> execution;
    public static volatile SingularAttribute<Project, Float> cost;
    public static volatile SingularAttribute<Project, String> name;
    public static volatile SingularAttribute<Project, Long> id;
    public static volatile SingularAttribute<Project, Date> deadline;
    public static volatile SingularAttribute<Project, Worker> worker;

}