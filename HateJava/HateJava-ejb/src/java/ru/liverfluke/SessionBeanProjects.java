
package ru.liverfluke;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.ejb.Stateless;

@Stateless
public class SessionBeanProjects implements FirstIFace {

    private static final String PROPERTIES_FILENAME = "application.properties";
    private static final String DB_URL_PROPERTY = "db.url";
    private static final String DB_USERNAME_PROPERTY = "db.username";
    private static final String DB_PASSWORD_PROPERTY = "db.password";
    private static final Properties settings = new Properties();
    private static Connection connection;
    
    public static final String SQL_select_all = "Select * from Projects";
    //public static final String SQL_select_by_id = "Select * from Projects where project_id = ?";
    //public static final String SQL_delete_by_id = "Delete from Projects where project_id = ?";
    //public static final String SQL_update_by_id = "Update Projects set worker_id= ? where project_id = ?";
    //public static final String SQL_insert = "insert into Projects (name, deadline, execution, cost, worker_id)" + " values (?, ?, ?, ?, ?)";
    
    private void establishConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println("Произошла ошибка при загрузке MySQL драйвера.");
            System.exit(1);
        }
        try {
            this.connection = (Connection) DriverManager.getConnection(
                settings.getProperty(DB_URL_PROPERTY),
                settings.getProperty(DB_USERNAME_PROPERTY),
                settings.getProperty(DB_PASSWORD_PROPERTY));
        } catch (SQLException sqle) {
            System.out.println("Произошла ошибка при установке соединения с БД: ");
            System.out.println(sqle.getMessage());
            System.exit(1);
        }
    }

    private void closeConnection() {
        try {
            if (this.connection != null) {
                this.connection.close();
            }
        } catch (SQLException sqle) {
            System.out.println("Произошла ошибка при закрытии соединения:");
            System.out.println(sqle.getMessage());
        }
    }

    private void loadProperties() {
        InputStream inputStream = null;
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILENAME);
            this.settings.load(inputStream);
        } catch (IOException ioe) {
            System.out.println("Произошла ошибка при загрузке параметров подключения к БД");
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ioe) {
                // do nothing
            }
        }
    }
    
    @Override
    public List<Project> getAll() {
        loadProperties();
        establishConnection();
        
        List<Project> projects = new ArrayList<>();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps = this.connection.prepareStatement(SQL_select_all);
            rs = ps.executeQuery();
        
        while (rs.next()) {
            Project p =new Project();
            p.setProject_id(rs.getInt(1));
            p.setName(rs.getString(2));
            p.setDeadline(rs.getString(3));
            p.setExecution(rs.getBoolean(4));
            p.setCost(rs.getFloat(5));
            p.setWorker_id(rs.getInt(6));
            projects.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Произошла ошибка при установке соединения с БД: ");
            System.out.println(ex.getMessage());
            System.exit(1);
        }finally {
            try {
                if ( rs != null && !rs.isClosed()) {rs.close();}
            } catch (SQLException e) {}
            try {
                if (ps != null && !ps.isClosed()) {ps.close();}
            } catch (SQLException e) {}
        }
        closeConnection();
        return projects;
    }
   
}
