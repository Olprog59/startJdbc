package com.formation.start_jdbc.repositories;

import com.formation.start_jdbc.dao.CRUD;
import com.formation.start_jdbc.models.Livre;

import java.util.List;
import java.util.Optional;

public interface LivreRepository extends CRUD<Livre, String> {
    Optional<List<Livre>> findByTitle(String titre);
}
