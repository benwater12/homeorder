package com.home.order.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.order.Enitiy.FoodOrder;
import com.home.order.repo.RepositoryOrder;


@Controller
@RequestMapping(path="/order")
public class OrderController {
    @Autowired
     private RepositoryOrder repositoryOrder;

  @GetMapping(path="/addtest") 
  public @ResponseBody String addNewOrder () throws ParseException {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
    FoodOrder n = new FoodOrder();
    n.setItem_ID(123);
    //set now as date
    n.setOrder_date(new Date());
    n.setPerson_ID(0);
    n.setOrder_specific("A");
    repositoryOrder.save(n);
    return "Saved";
  }

  
  @PostMapping(path="/{name}") 
  public @ResponseBody String addNewOrder (@PathVariable String name,String Item_name,String Order_specific) throws ParseException {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
    FoodOrder n = new FoodOrder();
    n.setItem_ID(123);
    //set now as date
    n.setOrder_date(new Date());
    n.setPerson_ID(0);
    n.setOrder_specific(Order_specific);
    repositoryOrder.save(n);
    return "Saved";
  }

  @GetMapping(path="/{name}") 
  public @ResponseBody Iterable<FoodOrder> getAllOrder() {
    // This returns a JSON or XML with the users
    return repositoryOrder.findAll();
  }
}
