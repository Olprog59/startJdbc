package com.formation.start_jdbc.services;

import com.formation.start_jdbc.models.Livre;
import com.formation.start_jdbc.repositories.LivreRepository;

import java.util.Collection;
import java.util.List;

public class LivreService implements LivreRepository {

    @Override
    public List<Livre> findByTitle(String titre) {
        return null;
    }

    @Override
    public Collection<Livre> findAll() {
        return null;
    }

    @Override
    public Livre findByID(String s) {
        return null;
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
    public int deleteByID(String s) {
        return 0;
    }
}
