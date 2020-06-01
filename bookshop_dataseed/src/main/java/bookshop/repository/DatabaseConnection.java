package bookshop.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import bookshop.config.*;

public class DatabaseConnection {

    private static DatabaseConnection instance = null;

    private DatabaseConnection(){}

    public static DatabaseConnection getInstance(){
        return (instance == null) ? new DatabaseConnection() : instance;
    }
   
    public Connection getConnection() {
        
        final DBProperties properties = new DBProperties();
        final String url = properties.URL + ":" + properties.PORT + "/" + properties.DATABASE;
        Connection connection=null;
        try {
            connection = DriverManager.getConnection(url, properties.USER_NAME, properties.USER_PASSWORD);
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return connection;

    }
    
}