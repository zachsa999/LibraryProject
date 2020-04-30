package com.javalearners.libraryapp.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2Connection implements AutoCloseable {
    private static H2Connection instance;
    private Connection connection;

    private H2Connection() throws SQLException{
        String fileName = "src/main/resources/property/h2.properties";
        String url;
        String username;
        String password;
        //String dbName;
        Properties properties = new Properties();

        try(InputStream in = new FileInputStream(fileName)){
            properties.load(in);
            url = properties.getProperty("db.url");
            //dbName = properties.getProperty("db.name");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");
            connection = DriverManager.getConnection(url, username, password);

        } catch(IOException e){
            System.out.println("Error loading " + fileName + "!");
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public static H2Connection getInstance() throws SQLException {
        if(instance == null){
            instance = new H2Connection();
        } else if(instance.getConnection().isClosed()){
            instance = new H2Connection();
        }
        return instance;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
