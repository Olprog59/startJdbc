package com.formation.start_jdbc.services;

import com.formation.start_jdbc.dao.ConnectionMySQL;
import com.formation.start_jdbc.models.Livre;
import com.formation.start_jdbc.repositories.LivreRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class LivreService implements LivreRepository {

    @Override
    public Optional<List<Livre>> findByTitle(String titre) {
        return null;
    }

    @Override
    public Optional<Collection<Livre>> findAll() {
        return null;
    }

    @Override
    public Optional<Livre> findByID(String id) {
        Livre livre = null;
        try (Connection c = ConnectionMySQL.getInstance()) {

            String query = "select * from livre where isbn = ?";
            try (PreparedStatement st = c.prepareStatement(query)) {
                st.setString(1, id);
                try (ResultSet res = st.executeQuery()) {
                    while (res.next()) {
                        livre = new Livre();
                        livre.setIsbn(res.getString("isbn"));
                        livre.setTitre(res.getString("titre"));
                        livre.setAuteurNom(res.getString("auteur_nom"));
                        livre.setAuteurPrenom(res.getString("auteur_prenom"));
                        livre.setEditeur(res.getString("editeur"));
                        livre.setAnnee(res.getInt("annee"));
                    }
                }
            } catch (SQLException s) {
                s.printStackTrace();
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return Optional.ofNullable(livre);
    }

    @Override
    public int save(Livre objet) {
        return 0;
    }

    @Override
    public int delete(Livre objet) {
        return 0;
    }

    @Override
    public int deleteByID(String id) {
        try (Connection c = ConnectionMySQL.getInstance()) {

            String query = "DELETE from livre where isbn = ?";
            try (PreparedStatement st = c.prepareStatement(query)) {
                st.setString(1, id);

                return st.executeUpdate();
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return 0;
    }
}
