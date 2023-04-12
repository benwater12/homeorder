package com.home.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.order.Enitiy.Person;
import com.home.order.repo.RepositoryPerson;
@Service
public class BalanceService {
    @Autowired
    RepositoryPerson repositoryPerson;
    public int NewBalance(String name, int amount)throws IndexOutOfBoundsException{
      int current_balance= repositoryPerson.BalanceFindByPerson_name(name);
      int new_balance=current_balance+amount;
      return new_balance;
    }
    public Person BalanceUpdate(String name,int amount)throws IndexOutOfBoundsException{
        return repositoryPerson.BalanceUpdateByPerson_name(NewBalance(name, amount), name);
    }
    
    
}
