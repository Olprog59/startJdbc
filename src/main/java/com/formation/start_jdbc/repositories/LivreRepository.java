package com.formation.start_jdbc.repositories;

import com.formation.start_jdbc.dao.CRUD;
import com.formation.start_jdbc.models.Livre;

import java.util.List;

public interface LivreRepository extends CRUD<Livre, String> {
    List<Livre> findByTitle(String titre);
}
