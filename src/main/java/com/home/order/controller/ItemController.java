package com.home.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.order.repo.*;

@Controller
@RequestMapping("/item")
public class ItemController {
 @Autowired
 private RepositoryMerchant repositoryMerchant;
 @Autowired
 private RepositoryItem repositoryItem;
 
}
