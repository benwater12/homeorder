package com.home.order.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.home.order.Enitiy.Item;
//impliment sql database relation
public interface RepositoryItem extends CrudRepository<Item,Integer> {
    @Query(value = "SELECT a FROM Item a WHERE a.item_name LIKE :Item_name")
    public List<Item> FindByItem_name(String Item_name);

}
