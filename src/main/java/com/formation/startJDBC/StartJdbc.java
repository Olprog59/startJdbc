package com.formation.startJDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class StartJdbc {
    public static void main(String[] args){
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("conf.properties")){
            props.load(fis);
        }catch (IOException ioException){
            ioException.printStackTrace();
        }

        String driver = props.getProperty("jdbc.driver.class");
        String url = props.getProperty("jdbc.url");
        String login = props.getProperty("jdbc.login");
        String password = props.getProperty("jdbc.password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection =  DriverManager.getConnection(url, login, password);




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
