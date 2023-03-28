package com.home.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.home.order.Enitiy.FoodOrder;
import com.home.order.repo.RepositoryItem;
import com.home.order.repo.RepositoryMerchant;
import com.home.order.repo.RepositoryOrder;
import com.home.order.repo.RepositoryPerson;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Service
public class OrderService {
    @Autowired
    private RepositoryOrder repositoryOrder;
    @Autowired
    private RepositoryItem repositoryItem;
    @Autowired
    private RepositoryMerchant repositoryMerchant;
    @Autowired
    private RepositoryPerson repositoryPerson;  

    public DelegateOrdersum getOrderHistorybyperson_name(String person_name){
        // System.out.println(repositoryPerson.FindByPerson_name(person_name).get(0).getPerson_id());
        // System.out.println("ABC================");
        // System.out.println(repositoryOrder.FindByPerson_ID(repositoryPerson.FindByPerson_name(person_name).get(0).getPerson_id()));
        List<FoodOrder> allorder= repositoryOrder.FindByPerson_ID(repositoryPerson.FindByPerson_name(person_name).get(0).getPerson_id());
        int sum =repositoryOrder.FindOrderSumByPerson_ID(repositoryPerson.FindByPerson_name(person_name).get(0).getPerson_id());
        // int sum = ;
        return new DelegateOrdersum(allorder,sum);
        }

    public void setOrder(String name,String Item_name,String Merchant_name,String Order_specific,int Order_cost){
        FoodOrder n = new FoodOrder();
        //set now as date
        n.setOrder_date(new Date());
        n.setItem(repositoryItem.FindByItem_name(Item_name).get(0));
        n.setPerson(repositoryPerson.FindByPerson_name(name).get(0));
        n.setMerchant(repositoryMerchant.FindByMerchant_name(Merchant_name).get(0));
        n.setOrder_specific(Order_specific);
        n.setOrder_cost(Order_cost);
        repositoryOrder.save(n);
    }
    @Getter
    @Setter
    public class DelegateOrdersum{
    List<FoodOrder> allorder; 
    int ordersum;
    public DelegateOrdersum( List<FoodOrder> allorder, int ordersum) {
        this.allorder = allorder;
        this.ordersum = ordersum;
    }
    
}
}

