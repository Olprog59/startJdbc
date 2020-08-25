package com.formation.start_jdbc;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livre {

    private String isbn;
    private String titre;
    private String auteurNom;
    private String auteurPrenom;
    private String editeur;
    private int annee;

}
