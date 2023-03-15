package com.home.order.repo;
import org.springframework.data.repository.CrudRepository;

import com.home.order.Enitiy.FoodOrder;
//this is used to hold Order data.
// This will be AUTO IMPLEMENTED by Spring into a Bean called repositoryOrder
// CRUD refers Create, Read, Update, Delete
public interface RepositoryOrder extends CrudRepository<FoodOrder,Integer> {
    
}
