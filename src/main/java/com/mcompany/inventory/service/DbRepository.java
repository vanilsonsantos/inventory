package com.mcompany.inventory.service;

import java.math.BigInteger;
import java.util.List;


interface DbRepository<T>  {

    void create(T object);
    void update(T object);
    void delete(int id);
    T findOne(BigInteger id);
    List<T> findAll();
}
