package com.formation.start_jdbc;

import com.formation.start_jdbc.models.Livre;

import java.sql.*;
import java.util.Optional;

public class StartJdbc {


    public static void main(String[] args) {
        Livre livre = new Livre("978-2070368228",
                "1984",
                "george",
                "orwell",
                "Gallimard",
                1972);

//        int nb = add(livre);
//        System.out.println(nb + " row(s) insert");
//
//        Optional<Livre> livre1 = findByID(livre.getIsbn());
//        if (livre1.isPresent()){
//            System.out.println(livre1.get());
//        }
//
//        nb = deleteByID(livre.getIsbn());
//        System.out.println(nb + " row(s) delete");
    }
}
