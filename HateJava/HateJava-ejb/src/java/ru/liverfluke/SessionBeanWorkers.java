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
public class SessionBeanWorkers implements IWorker {

    private static final String PROPERTIES_FILENAME = "application.properties";
    private static final String DB_URL_PROPERTY = "db.url";
    private static final String DB_USERNAME_PROPERTY = "db.username";
    private static final String DB_PASSWORD_PROPERTY = "db.password";
    private static final Properties settings = new Properties();
    private static Connection connection;
    
    public static final String SQL_select_all = "Select * from Workers";
    public static final String SQL_get_earnings_by_id = "select sum(cost) from projects where worker_id=? and execution=1";
    
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
    
    @Override
    public List<Worker> getAll(){
        loadProperties();
        establishConnection();
        
        List<Worker> workers = new ArrayList<>();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps = this.connection.prepareStatement(SQL_select_all);
            rs = ps.executeQuery();
        
        while (rs.next()) {
            Worker w=new Worker(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getString(4));
            workers.add(w);
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
        return workers;
    }
    
    @Override
    public int countEarnings(int id){
        loadProperties();
        establishConnection();
        int sum=0;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        try {
            ps = this.connection.prepareStatement(SQL_get_earnings_by_id);
            ps.setInt(1, id);
            rs = ps.executeQuery();     
        while (rs.next()) {
            sum = rs.getInt(1);
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
        return sum;
    }
    
}
