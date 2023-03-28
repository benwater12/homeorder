package com.home.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.order.Enitiy.FoodOrder;
import com.home.order.repo.RepositoryItem;
import com.home.order.repo.RepositoryMerchant;
import com.home.order.repo.RepositoryOrder;
import com.home.order.repo.RepositoryPerson;

import lombok.Getter;


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
    public class DelegateOrdersum{
    List<FoodOrder> allorder; 
    int ordersum;
    public DelegateOrdersum( List<FoodOrder> allorder, int ordersum) {
        this.allorder = allorder;
        this.ordersum = ordersum;
    }
    public String ToString(){
        return Integer.toString(ordersum)+" "+allorder.get(0).getPerson().getPerson_id();
    }
    
}
}

