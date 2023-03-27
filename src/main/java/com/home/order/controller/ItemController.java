package com.home.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.order.Enitiy.Item;
import com.home.order.Enitiy.Merchant;
import com.home.order.repo.*;

@Controller
@RequestMapping("/item")
public class ItemController {
 @Autowired
 private RepositoryItem repositoryItem;
 @GetMapping(path="/addtest") 
 public @ResponseBody String addNewItemtest () {
   // @ResponseBody means the returned String is the response, not a view name
   // @RequestParam means it is a parameter from the GET or POST request
   return "Saved";
 }
}
