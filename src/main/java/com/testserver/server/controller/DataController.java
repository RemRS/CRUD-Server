package com.testserver.server.controller;

import com.testserver.server.entity.Data;
import com.testserver.server.service.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DataController {

    @Autowired
    private DataServiceImpl service;

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    @ResponseBody
    public List<Data> getAllResponse() {
        return service.getAll();
    }

    @RequestMapping(value = "/data/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Data getData(@PathVariable("id") long userID) {
        return service.getByID(userID);
    }

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @ResponseBody
    public Data saveReminder(@RequestBody Data data) {
        return service.save(data);
    }

    @RequestMapping(value = "/data/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") long userID) {
        service.remove(userID);
    }
}
