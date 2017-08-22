package com.testserver.server.service;

import com.testserver.server.entity.Data;
import com.testserver.server.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataRepository repository;

    public List<Data> getAll() {
        return repository.findAll();
    }

    public Data getByID(long id) {
        return repository.findOne(id);
    }

    public Data save(Data data) {
        return repository.saveAndFlush(data);
    }

    public void remove(long id) {
        repository.delete(id);
    }
}
