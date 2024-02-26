package com.kent0k.customers.service;

import java.util.List;

public interface OwnerService<P, S, U> {

    boolean save(S saveDto);

    P fetch(Integer id);

    List<P> fetchAll();

    boolean update(U updateDto);

    boolean delete(Integer id);
}
