package com.interview.test.sfl.restourant.controller;

import com.interview.test.sfl.restourant.model.RestourantTable;
import com.interview.test.sfl.restourant.service.RestourantService;
import com.interview.test.sfl.restourant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TableController {

    @Autowired
    RestourantService restourantService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/tables",method = RequestMethod.GET)
    public ResponseEntity<List<RestourantTable>> getTables(){
        return new ResponseEntity<>(restourantService.getRestourantTables(), HttpStatus.OK);
    }

    @RequestMapping(value = "/tables/users/{id}",method = RequestMethod.GET)
    public ResponseEntity<List<RestourantTable>> getTables(@PathVariable("id") Long userId){
        return new ResponseEntity<>(restourantService.findRestourantTablesByUser(userService.getUser(userId)), HttpStatus.OK);
    }

    @RequestMapping(value = "/tables/{table_id}/users/{user_id}",method = RequestMethod.PUT )
    public ResponseEntity<RestourantTable> addTable(@PathVariable("table_id") Long tableId, @PathVariable("user_id") Long userId){
        RestourantTable restourantTable = restourantService.getRestourantTable(tableId);
        restourantTable.setUser(userService.getUser(userId));
        return new ResponseEntity<>(restourantService.save(restourantTable),HttpStatus.OK);
    }

    @RequestMapping(value = "/tables",method = RequestMethod.POST)
    public ResponseEntity<RestourantTable> addTable(@RequestParam(name = "name",required = true) String name){
        RestourantTable restourantTable = new RestourantTable();
        restourantTable.setName(name);
        return new ResponseEntity<>(restourantService.save(restourantTable),HttpStatus.OK);
    }

}
