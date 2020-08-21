package com.formation.startJDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
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

            // 978-2-07-508252-5
            String query = "select * from livre where isbn = ?";
            try (PreparedStatement st = connection.prepareStatement(query)){
                st.setString(1, "978-2-07-508255-6");

                ResultSet res = st.executeQuery();

                while(res.next()){
//                    System.out.println(res.getString(2));

                    System.out.printf("l'isbn: %s, titre: %s, nom de l'auteur: %s, prénom de l'auteur: %s, l'éditeur: %s, l'année: %d\n",
                            res.getString("isbn"),
                            res.getString("titre"),
                            res.getString("auteur_nom"),
                            res.getString("auteur_prenom"),
                            res.getString("editeur"),
                            res.getInt("annee")
                            );
                }


            }catch (SQLException s){
                s.printStackTrace();
            }

            query = "INSERT into livre values (?,?,?,?,?,?)";
            try (PreparedStatement st = connection.prepareStatement(query) ){
                st.setString(1, "978-2070368228");
                st.setString(2, "1984");
                st.setString(3, "george");
                st.setString(4, "orwell");
                st.setString(5, "Gallimard");
                st.setInt(6, 1972);

                int nb = st.executeUpdate();
                System.out.printf("%d ligne(s) update\n", nb);
            }

            query = "DELETE from livre where isbn = ?";
            try (PreparedStatement st = connection.prepareStatement(query) ){
                st.setString(1, "978-2070368228");

                int nb = st.executeUpdate();
                System.out.printf("%d ligne(s) update\n", nb);
            }

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
