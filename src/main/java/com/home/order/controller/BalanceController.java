package com.home.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.order.repo.RepositoryPerson;
import com.home.order.service.BalanceService;
@Controller
@RequestMapping(value = "/balance")
public class BalanceController {
    @Autowired
    RepositoryPerson repositoryperson;
    @Autowired
    BalanceService balanceService;
    @GetMapping(path="/{name}") 
    public ResponseEntity<String>  personBalance(@PathVariable String name) {
        int value=0;
        try{
        value=repositoryperson.BalanceFindByPerson_name(name);
        }
        catch(IndexOutOfBoundsException exception){
            return new ResponseEntity<String>("Not Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(Integer.toString(value),HttpStatus.OK);
    }
    @PutMapping(path="/{name}") 
    public ResponseEntity<String>  personBalance_change(@PathVariable String name,int amount) {
        try{
            balanceService.BalanceUpdate(name, amount);
        }
        catch(IndexOutOfBoundsException exception){
            return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(name+" current balance is:"+Integer.toString(repositoryperson.BalanceFindByPerson_name(name)),HttpStatus.OK);
    }

}
