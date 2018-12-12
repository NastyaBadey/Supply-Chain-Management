package com.scm.services.dao;

import java.util.List;

public interface Dao<T> {
    void add (T entity);
    void update (T entity);
    void remove (int id);
    T getById (int id);
    List<T> getAll ();
}
