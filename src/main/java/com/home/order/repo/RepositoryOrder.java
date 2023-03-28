package com.home.order.repo;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.home.order.Enitiy.FoodOrder;
//this is used to hold Order data.
// This will be AUTO IMPLEMENTED by Spring into a Bean called repositoryOrder
// CRUD refers Create, Read, Update, Delete
public interface RepositoryOrder extends CrudRepository<FoodOrder,Integer> {
    @Query(value = "SELECT a FROM FoodOrder a WHERE a.person = :Person_ID")
    public List<FoodOrder> FindByPerson_ID(long Person_ID);
    @Query(value = "SELECT SUM(a.order_cost) FROM FoodOrder a WHERE a.person = :Person_ID")
    public int FindOrderSumByPerson_ID(long Person_ID);

}
