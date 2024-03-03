package com.crio.jukebox.repositories;

import java.util.List;
import java.util.Optional;

public interface CRUDRepositories<T,ID> {
    T save(T entity);
    List<T> findAll();
    Optional<T> findById(ID id);
    boolean existsById(ID id);
    void delete(T entity);
    void deleteById(ID id);
    long count();
}
