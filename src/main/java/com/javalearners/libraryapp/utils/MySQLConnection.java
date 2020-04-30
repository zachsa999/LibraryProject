package com.javalearners.libraryapp.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnection {
    private static MySQLConnection instance;
    private Connection connection;

    private MySQLConnection() throws SQLException{
        String fileName = "src/main/resources/property/mysql.properties";
        String url;
        String username;
        String password;
        String dbName;
        Properties properties = new Properties();

        try(InputStream in = new FileInputStream(fileName)){
            properties.load(in);
            url = properties.getProperty("db.url");
            dbName = properties.getProperty("db.name");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");
            connection = DriverManager.getConnection(url+dbName, username, password);

        } catch(IOException e){
            System.out.println("Error loading " + fileName + "!");
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public static MySQLConnection getInstance() throws SQLException {
        if(instance == null){
            instance = new MySQLConnection();
        } else if(instance.getConnection().isClosed()){
            instance = new MySQLConnection();
        }
        return instance;
    }
}
