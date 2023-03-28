package com.home.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.order.Enitiy.Merchant;
import com.home.order.repo.RepositoryMerchant;

@Controller
@RequestMapping("/merchant")
public class MerchantController {
    @Autowired
    RepositoryMerchant repositoryMerchant;
    @GetMapping("/addtest")
    public @ResponseBody String addTest(){
        Merchant merchant=new Merchant();
        merchant.setInBusiness(true);
        merchant.setMerchant_name("BOAI");
        merchant.setMerchant_id(1);
        repositoryMerchant.save(merchant);
        return "addedtestpass";
        
    }
}
