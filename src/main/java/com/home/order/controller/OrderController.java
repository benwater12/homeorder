package com.home.order.controller;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

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
  @ResponseStatus(HttpStatus.OK)
  public @ResponseBody String addNewOrder (@PathVariable String name,String Item_name,String Merchant_name,String Order_specific,int Order_cost) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request
    FoodOrder n = new FoodOrder();
    
    
    //set now as date
    n.setOrder_date(new Date());
    try{
        orderService.setOrder(name, Item_name, Merchant_name, Order_specific, Order_cost);
    }
    catch(IndexOutOfBoundsException a){
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND, "Input data not match current database."
      );
    }
    return "order_placed";
  }

  @GetMapping(path="/{name}") 
  public @ResponseBody String getAllOrder(@PathVariable String name) {

    DelegateOrdersum response;
    try{
      response=orderService.getOrderHistorybyperson_name(name);
    }
    catch(IndexOutOfBoundsException a){
      throw new ResponseStatusException(
        HttpStatus.NOT_FOUND, "Input data not match current database."
      );
    }
    return response.ToString();

  }
}
