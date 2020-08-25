package com.formation.start_jdbc.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionMySQL {

    private ConnectionMySQL() {
    }

    private static String url;
    private static String login;
    private static String password;

    private static void getProperties(){
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("conf.properties")) {
            props.load(fis);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        url = props.getProperty("jdbc.url");
        login = props.getProperty("jdbc.login");
        password = props.getProperty("jdbc.password");
    }

    private static Connection connect;

    public static Connection getInstance(){
        if (connect == null) {
            getProperties();
            try {
                connect = DriverManager.getConnection(url, login, password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connect;
    }

}
