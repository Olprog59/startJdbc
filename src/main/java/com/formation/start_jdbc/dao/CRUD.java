package com.formation.start_jdbc.dao;

import java.util.Collection;
import java.util.Optional;

public interface CRUD<M, ID> {
    Optional<Collection<M>> findAll();
    Optional<M> findByID(ID id);
    int save(M objet);
    int delete(M objet);
    int deleteByID(ID id);
}
