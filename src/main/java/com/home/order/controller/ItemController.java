package com.home.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.order.Enitiy.Item;
import com.home.order.Enitiy.Merchant;
import com.home.order.repo.RepositoryItem;

@Controller
@RequestMapping("/item")
public class ItemController {
 @Autowired
 RepositoryItem repositoryItem;
 @GetMapping(path="/addtest") 
 public @ResponseBody String addNewItemtest () {
  Item item = new Item();
  item.setItem_id(1);
  item.setItem_name("StinkyTofu");
  item.setItem_specific("Spicy");
  Merchant merchant=new Merchant();
  merchant.setInBusiness(true);
  merchant.setMerchant_name("BOAI");
  merchant.setMerchant_id(2);
  item.setMerchant(merchant);
  item.setPrice(50);
  repositoryItem.save(item);
   return "Saved Item Added";
 }
}
