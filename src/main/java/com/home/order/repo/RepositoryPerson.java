package com.home.order.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.home.order.Enitiy.Person;

public interface RepositoryPerson extends CrudRepository<Person,Integer> {
    @Query(value = "SELECT a FROM Person a WHERE a.person_name LIKE :Person_name")
    public List<Person> FindByPerson_name(String Person_name);
    @Query(value = "SELECT a.balance FROM Person a WHERE a.person_name LIKE :Person_name")
    public Integer BalanceFindByPerson_name(String Person_name);
    @Query(value = "UPDATE Person a SET a.balance=:Balance WHERE a.person_name LIKE :Person_name")
    public Person BalanceUpdateByPerson_name(int Balance,String Person_name);
}
