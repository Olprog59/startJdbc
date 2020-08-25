package com.formation.start_jdbc;

import com.formation.start_jdbc.models.Livre;
import com.formation.start_jdbc.services.LivreService;

import java.sql.*;
import java.util.Collection;
import java.util.Optional;

public class StartJdbc {


    public static void main(String[] args) {
        Livre livre = new Livre("978-2070368228",
                "1984",
                "george",
                "orwell",
                "Gallimard",
                1972);

        LivreService livreService = new LivreService();

        Optional<Collection<Livre>> livres = livreService.findAll();
        if (livres.isPresent()){
            livres.get().forEach(System.out::println);
        }
//        int nb = livreService.save(livre);
//        System.out.println(nb + " row(s) insert");
//
//        Optional<Livre> livre1 = livreService.findByID(livre.getIsbn());
//        if (livre1.isPresent()){
//            System.out.println(livre1.get());
//        }
//
//        nb = livreService.deleteByID(livre.getIsbn());
//        System.out.println(nb + " row(s) delete");

        livreService.closeConnection();
    }
}
