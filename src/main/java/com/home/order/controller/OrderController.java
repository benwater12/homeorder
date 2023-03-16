package com.home.order.controller;



import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.order.Enitiy.FoodOrder;
import com.home.order.repo.*;


@Controller
@RequestMapping(path="/order")
public class OrderController {
    @Autowired
     private RepositoryOrder repositoryOrder;
     @Autowired
     private RepositoryItem repositoryItem;
     @Autowired
     private RepositoryMerchant repositoryMerchant;
     @Autowired
     private RepositoryPerson repositoryPerson;

  @GetMapping(path="/addtest") 
  public @ResponseBody String addNewOrdertest () {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
    FoodOrder n = new FoodOrder();
    n.setItem_ID(123);
    //set now as date
    n.setOrder_date(new Date());
    n.setPerson_ID(152);
    n.setOrder_specific("A");
    repositoryOrder.save(n);
    return "Saved";
  }

  
  @PostMapping(path="/{name}") 
  public @ResponseBody String addNewOrder (@PathVariable String name,String Item_name,String Merchant_name,String Order_specific) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
    FoodOrder n = new FoodOrder();
    
    n.setItem_ID(repositoryItem.FindByItem_name(Item_name).get(0).getItem_id());
    //set now as date
    n.setOrder_date(new Date());
    n.setPerson_ID(repositoryPerson.FindByPerson_name(name).get(0).getPerson_id());
    n.setMerchant_ID(repositoryMerchant.FindByMerchant_name(Merchant_name).get(0).getMerchant_id());
    n.setOrder_specific(Order_specific);
    repositoryOrder.save(n);
    return "Saved";
  }

  @GetMapping(path="/{name}") 
  public @ResponseBody Iterable<FoodOrder> getAllOrder(@PathVariable String name) {
    // This returns a JSON or XML with the users
    System.out.println(repositoryPerson.FindByPerson_name(name).get(0).getPerson_id());
    return repositoryOrder.FindByPerson_ID(repositoryPerson.FindByPerson_name(name).get(0).getPerson_id());
  }
}
