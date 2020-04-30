package com.javalearners.libraryapp;

import com.javalearners.libraryapp.utils.H2Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String sql = "CREATE TABLE TEST " +
                "(id INTEGER not NULL, " +
                " first VARCHAR(255), " +
                " last VARCHAR(255), " +
                " age INTEGER, " +
                " PRIMARY KEY ( id ))";
        String sql2 = "INSERT INTO TEST " +
                "VALUES (100, 'Zara', 'Ali', 18)";
        System.out.println("test");

        try(H2Connection connector = H2Connection.getInstance()){
            var connection = connector.getConnection();
            try(Statement statement = connection.createStatement()){
                //statement.executeUpdate(sql);
                statement.executeUpdate(sql2);
                try(ResultSet resultSet = statement.executeQuery("SELECT * FROM TEST")){
                    while(resultSet.next()){

                        System.out.println(resultSet.getString("first"));
                    }
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
