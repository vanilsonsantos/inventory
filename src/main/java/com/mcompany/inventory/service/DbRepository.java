package com.mcompany.inventory.service;

import java.util.List;


interface DbRepository<T>  {

    void create(T object);
    void update(T object);
    void delete(Long id);
    T findOne(Long id);
    List<T> findAll();
}
