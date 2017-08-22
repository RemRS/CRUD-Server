package com.testserver.server.service;

import com.testserver.server.entity.Data;

import java.util.List;

public interface DataService {
    List<Data> getAll();
    Data getByID(long id);
    Data save(Data data);
    void remove(long id);
}
