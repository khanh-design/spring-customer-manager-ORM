package com.example.springcustomermanagerorm.service;

import java.util.List;

public interface GeneralDAO<E> {
    List<E> findAll();
    E getById(int id);
    void save(E entity);
//    void update(E entity);
//    void delete(int id);
}
