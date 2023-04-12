package com.home.order.controller;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.home.order.Enitiy.FoodOrder;
import com.home.order.repo.*;
import com.home.order.service.OrderService;
import com.home.order.service.OrderService.DelegateOrdersum;


@Controller
@RequestMapping(path="/order")
public class OrderController {
    @Autowired
     private RepositoryOrder repositoryOrder;
     @Autowired
     private RepositoryItem repositoryItem;
     @Autowired
     private RepositoryPerson repositoryPerson;
     @Autowired
     private RepositoryMerchant repositoryMerchant;
     @Autowired
     private OrderService orderService;

  @GetMapping(path="/addtest") 
  public @ResponseBody String addNewOrdertest () {
    FoodOrder foodOrder=new FoodOrder(); 
    foodOrder.setFood_order_id(0);
    foodOrder.setItem(repositoryItem.FindByItem_name("StinkyTofu").get(0));
    foodOrder.setMerchant(repositoryMerchant.FindByMerchant_name("BOAI").get(0));
    foodOrder.setOrder_cost(200);
    foodOrder.setOrder_specific("1223");
    foodOrder.setPerson(repositoryPerson.FindByPerson_name("Benson").get(0));
    foodOrder.setOrder_date(new Date());
    repositoryOrder.save(foodOrder);
    return "Saved";
  }

  
  @PostMapping(path="/{name}") 
  public  ResponseEntity<String> addNewOrder (@PathVariable String name,String Item_name,String Merchant_name,String Order_specific,int Order_cost) {
    FoodOrder n = new FoodOrder();
    n.setOrder_date(new Date());
    try{
        orderService.setOrder(name, Item_name, Merchant_name, Order_specific, Order_cost);
    }
    catch(IndexOutOfBoundsException a){
      return new ResponseEntity<String>("Input data not match current database.", HttpStatus.NOT_FOUND);
    }
    return  new ResponseEntity<String>("order_placed",HttpStatus.OK);
  }

  @GetMapping(path="/{name}") 
  public ResponseEntity<String> getAllOrder(@PathVariable String name) {

    DelegateOrdersum response;
    try{
      response=orderService.getOrderHistorybyperson_name(name);
    }
    catch(IndexOutOfBoundsException a){
      return new ResponseEntity<String>("Input data not match current database.", HttpStatus.NOT_FOUND);
    }
    Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
    String prettyJsonString = gsonPretty.toJson(response.getAllorder());
    return new ResponseEntity<String>(prettyJsonString, HttpStatus.OK);

  }
}
