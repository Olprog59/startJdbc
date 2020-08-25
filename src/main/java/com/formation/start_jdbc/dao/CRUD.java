package com.formation.start_jdbc.dao;

import java.util.Collection;

public interface CRUD<M, ID> {
    Collection<M> findAll();
    M findByID(ID id);
    int save(M objet);
    int delete(M objet);
    int deleteByID(ID id);
}
